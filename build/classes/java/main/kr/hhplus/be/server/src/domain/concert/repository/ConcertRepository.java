package src.domain.concert.repository;

import src.domain.concert.entity.*;

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
