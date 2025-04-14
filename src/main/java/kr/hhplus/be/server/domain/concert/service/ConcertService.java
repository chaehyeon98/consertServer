package domain.concert.service;

import domain.concert.entity.*;

import java.math.BigInteger;
import java.util.List;

public interface ConcertService {

    List<Concert> getConcert(String name);

    List<ConcertDate> getDate(BigInteger concertId, User user);

    List<ConcertSeat> getSeatList(BigInteger concert_date_id, User user);

    Reservation getReservation(User user, BigInteger seat_id);

    ConcertSeat getConcertSeat(BigInteger seat_id);

    void setStatus(ConcertSeat concertSeat);
}
