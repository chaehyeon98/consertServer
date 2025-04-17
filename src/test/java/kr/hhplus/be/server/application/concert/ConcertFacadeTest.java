package kr.hhplus.be.server.application.concert;

import kr.hhplus.be.server.application.concert.Facade.ConcertFacade;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.enums.ReservationStatusEnum;
import kr.hhplus.be.server.domain.concert.enums.SeatStatusEnum;
import kr.hhplus.be.server.domain.concert.repository.ConcertSeatRepository;
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
public class ConcertFacadeTest {

    @Autowired
    private ConcertFacade concertFacade;

    ConcertSeat concertSeat;

    @Autowired
    private ConcertSeatRepository concertSeatRepository;

    @BeforeEach
    public void setUp() {

        concertSeat = new ConcertSeat(111, 11, 176000, SeatStatusEnum.available, 1);
        concertSeatRepository.save(concertSeat);
        concertSeat = new ConcertSeat(112, 11, 176000, SeatStatusEnum.blocked, 2);
        concertSeatRepository.save(concertSeat);
    }

    @Test
    @DisplayName("콘서트 예약 usecase 테스트")
    public void getReservationTest(){

        //given
        User tempUser = new User(1, "token_test", new Date());

        // when
        Reservation result = concertFacade.getReservation(tempUser, 111);

        // then
        assertThat(result.getSeat_id()).isEqualTo(111);
        assertThat(result.getUser_id()).isEqualTo(1);
        assertThat(result.getSeat_number()).isEqualTo(1);
        assertThat(result.getStatus()).isEqualTo(ReservationStatusEnum.reserved);

    }

    @Test
    @DisplayName("콘서트 예약 usecase 예약실패 테스트")
    public void getReservationTest2(){

        //given
        User tempUser = new User(1, "token_test", new Date());

        // when & then
        assertThatThrownBy(() -> concertFacade.getReservation(tempUser, 112))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 선택된 좌석");

    }

}
