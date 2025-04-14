package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.ReservationEntity;
import kr.hhplus.be.server.domain.user.entity.BalanceEntity;

public interface ConcertPayRepository {
    int updateBalance(BalanceEntity balanceEntity);

    int insert(ReservationEntity reservation);
}
