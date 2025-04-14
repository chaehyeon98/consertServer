package kr.hhplus.be.server.domain.concert.service;


import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.entity.Balance;

public interface ConcertPayService {

    void setStatus(Reservation reservation);

    Balance subtractBalance(User user, ConcertSeat concertSeat);

    void restoreBalance(Balance balance, ConcertSeat concertSeat);
}
