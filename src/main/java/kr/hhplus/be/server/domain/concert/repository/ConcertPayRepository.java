package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.user.entity.Balance;

public interface ConcertPayRepository {
    int updateBalance(Balance balanceEntity);

    int insert(Reservation reservation);
}
