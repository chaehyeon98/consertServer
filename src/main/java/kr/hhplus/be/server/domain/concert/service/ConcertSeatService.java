package domain.concert.service;

import domain.concert.entity.ConcertSeat;
import domain.concert.entity.User;

import java.util.List;

public interface ConcertSeatService {

    List<ConcertSeat> getSeatList(long concert_date_id);

    ConcertSeat updateSeat(User user, long seat_id);

    ConcertSeat getConcertSeat(long seat_id);

    void setStatus(ConcertSeat concertSeat);
}
