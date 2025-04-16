package kr.hhplus.be.server.domain.concert.service;


import kr.hhplus.be.server.domain.concert.entity.Balance;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.User;

public interface ConcertPayService {

    Balance subtractBalance(User user, ConcertSeat concertSeat);

    void restoreBalance(Balance balance, ConcertSeat concertSeat);
}
