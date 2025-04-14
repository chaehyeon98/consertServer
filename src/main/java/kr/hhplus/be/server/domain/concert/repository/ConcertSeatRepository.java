package domain.concert.repository;

import domain.concert.entity.ConcertSeat;

import java.math.BigInteger;
import java.util.List;

public interface ConcertSeatRepository {

    List<ConcertSeat> getSeatList(BigInteger concert_date_id);

    ConcertSeat getSeat(BigInteger seat_id);

    int updateSeat(ConcertSeat concertSeat);
}
