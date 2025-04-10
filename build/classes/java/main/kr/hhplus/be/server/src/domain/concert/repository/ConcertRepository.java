package src.domain.concert.repository;

import src.domain.concert.entity.ConcertDateEntity;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.entity.ConcertSeatEntity;

import java.math.BigInteger;
import java.util.List;

public interface ConcertRepository {
    ConcertEntity getConcert(String name);

    List<ConcertDateEntity> getDate(BigInteger concertId);

    List<ConcertSeatEntity> getSeat(BigInteger seat_id);
}
