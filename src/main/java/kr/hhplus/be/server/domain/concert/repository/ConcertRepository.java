package domain.concert.repository;

import domain.concert.entity.Concert;
import domain.concert.entity.ConcertDate;
import domain.concert.entity.Reservation;

import java.math.BigInteger;
import java.util.List;

public interface ConcertRepository {
    List<Concert> getConcert(String name);

    List<ConcertDate> getDate(BigInteger concertId);

    int insertReservation(Reservation reservation);

}
