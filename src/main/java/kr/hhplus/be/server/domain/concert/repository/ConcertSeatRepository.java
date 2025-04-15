package domain.concert.repository;

import domain.concert.entity.ConcertSeat;

import java.util.List;

public interface ConcertSeatRepository {

    List<ConcertSeat> getSeatList(long concert_date_id);

    ConcertSeat getSeat(long seat_id);

    int updateSeat(ConcertSeat concertSeat);
}
