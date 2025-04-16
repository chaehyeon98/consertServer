package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.User;

import java.util.List;

public interface ConcertSeatService {

    List<ConcertSeat> getSeatList(long concert_date_id);

    ConcertSeat updateSeat(User user, long seat_id);

    ConcertSeat getConcertSeat(long seat_id);

    void setStatus(ConcertSeat concertSeat);
}
