package kr.hhplus.be.server.application.concert.service;

import kr.hhplus.be.server.domain.concert.entity.*;

import java.math.BigInteger;
import java.util.List;

public interface ConcertService {

    List<ConcertEntity> getConcert(String name);

    List<ConcertDateEntity> getDate(BigInteger concertId, UserEntity user);

    List<ConcertSeatEntity> getSeatList(BigInteger concert_date_id, UserEntity user);

    ReservationEntity getReservation(UserEntity user, BigInteger seat_id);
}
