package src.application.concert.service;

import src.domain.concert.entity.*;

import java.math.BigInteger;
import java.util.List;

public interface ConcertService {

    ConcertEntity getConcert(String name);

    List<ConcertDateEntity> getDate(BigInteger concertId, UserEntity user);

    List<ConcertSeatEntity> getSeatList(BigInteger concert_date_id, UserEntity user);

    void getReservation(UserEntity user, BigInteger seat_id);
}
