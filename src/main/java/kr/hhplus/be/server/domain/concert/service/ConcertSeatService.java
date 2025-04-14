package domain.concert.service;

import domain.concert.entity.ConcertSeat;
import domain.concert.entity.User;

import java.math.BigInteger;
import java.util.List;

public interface ConcertSeatService {

    List<ConcertSeat> getSeatList(BigInteger concert_date_id);

    ConcertSeat updateSeat(User user, BigInteger seat_id);

    ConcertSeat getConcertSeat(BigInteger seat_id);

    void setStatus(ConcertSeat concertSeat);
}
