package kr.hhplus.be.server.application.concert;

import kr.hhplus.be.server.application.concert.Facade.ConcertFacade;
import kr.hhplus.be.server.domain.concert.entity.Balance;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.enums.SeatStatusEnum;
import kr.hhplus.be.server.domain.concert.repository.BalanceRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertSeatRepository;
import kr.hhplus.be.server.domain.concert.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ComponentScan(basePackages = "kr.hhplus.be.server")
public class ConcertFacadeMockTest {

    @Autowired
    private ConcertFacade concertFacade;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private ConcertSeatRepository concertSeatRepository;

    @BeforeEach
    public void setUp() {
        concertSeatRepository.deleteAll();
        balanceRepository.deleteAll();
        userRepository.deleteAll();

        concertSeatRepository.save(new ConcertSeat(111, 11, 176000, SeatStatusEnum.available, 1));
        concertSeatRepository.save(new ConcertSeat(112, 11, 176000, SeatStatusEnum.available, 2));

        // 성공
        userRepository.save(new User(1L, "token_test", new Date()));
        balanceRepository.save(new Balance(1L, 300000));

        // 잔액 부족
        userRepository.save(new User(2L, "token_test", new Date()));
        balanceRepository.save(new Balance(2L, 100000));

        // 토큰 없음 (null)
        userRepository.save(new User(3L));
        balanceRepository.save(new Balance(3L, 300000));
    }

    @Test
    @DisplayName("결제 실패 - 잔액 부족 시 balance 복원 확인")
    void testPayFail_dueToInsufficientBalance() {
        // given
        User user = userRepository.findById(2L).orElseThrow();
        Reservation reservation = new Reservation(112L, 2L, 2);

        // when & then
        assertThatThrownBy(() -> concertFacade.pay(user, reservation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Amount must be less than or equal to the price");

        // 복원되었는지 확인: balance 원상복귀 여부
        Balance balance = balanceRepository.findById(2L).orElseThrow();
        assertThat(balance.getAmount()).isEqualTo(100000);
    }

    @Test
    @DisplayName("결제 실패 - 토큰 검증 실패 시 balance 복원 확인")
    void testPayFail_dueToTokenInvalid() {
        // given
        User user = userRepository.findById(3L).orElseThrow();
        Reservation reservation = new Reservation(111L, 3L, 1);

        // when & then
        assertThatThrownBy(() -> concertFacade.pay(user, reservation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("토큰 없음");

        // 복원 여부 확인
        Balance balance = balanceRepository.findById(3L).orElseThrow();
        assertThat(balance.getAmount()).isEqualTo(300000);
    }
}