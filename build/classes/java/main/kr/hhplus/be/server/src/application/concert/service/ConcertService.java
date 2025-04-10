package src.application.concert.service;

import src.domain.concert.entity.ConcertDateEntity;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.entity.ConcertSeatEntity;
import src.domain.concert.entity.UserEntity;

import java.math.BigInteger;
import java.util.List;

public interface ConcertService {

    ConcertEntity getConcert(String name);

    List<ConcertDateEntity> getDate(BigInteger concertId, UserEntity user);

    List<ConcertSeatEntity> getSeat(BigInteger seat_id, UserEntity user);
}
