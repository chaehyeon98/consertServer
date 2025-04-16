package kr.hhplus.be.server.domain.concert;

import kr.hhplus.be.server.domain.concert.entity.Concert;
import kr.hhplus.be.server.domain.concert.repository.ConcertRepository;
import kr.hhplus.be.server.domain.concert.service.ConcertService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
@ComponentScan(basePackages = "kr.hhplus.be.server")
public class ConcertServiceTest {

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ConcertService concertService;

    private Concert concert;

    @BeforeEach
    public void setUp() {
        concert = new Concert(1, "요루시카");

        concertRepository.save(concert);
    }

    @Test
    @DisplayName("콘서트목록조회 usecase 테스트")
    public void getConcertTest(){

        // when
        List<Concert> result = concertService.getConcert();

        // then
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getConcert_name()).isEqualTo("요루시카");

    }

}
