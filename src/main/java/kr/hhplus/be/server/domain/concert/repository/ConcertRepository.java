package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.ConcertDateEntity;
import kr.hhplus.be.server.domain.concert.entity.ConcertEntity;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeatEntity;
import kr.hhplus.be.server.domain.concert.entity.ReservationEntity;

import java.math.BigInteger;
import java.util.List;

public interface ConcertRepository {
    List<ConcertEntity> getConcert(String name);

    List<ConcertDateEntity> getDate(BigInteger concertId);

    List<ConcertSeatEntity> getSeatList(BigInteger concert_date_id);

    ConcertSeatEntity getSeat(BigInteger seat_id);

    int insertReservation(ReservationEntity reservation);

    int updateSeat(ReservationEntity reservation);

}
