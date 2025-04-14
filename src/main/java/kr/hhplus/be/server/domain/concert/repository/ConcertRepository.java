package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.ConcertDate;
import kr.hhplus.be.server.domain.concert.entity.Concert;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;

import java.math.BigInteger;
import java.util.List;

public interface ConcertRepository {
    List<Concert> getConcert(String name);

    List<ConcertDate> getDate(BigInteger concertId);

    List<ConcertSeat> getSeatList(BigInteger concert_date_id);

    ConcertSeat getSeat(BigInteger seat_id);

    int insertReservation(Reservation reservation);

    int updateSeat(ConcertSeat concertSeat);

    int updateSeat(Reservation reservation);
}
