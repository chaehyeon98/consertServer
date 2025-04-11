package src.domain.concert.repository;

import src.domain.concert.entity.ReservationEntity;
import src.domain.user.entity.BalanceEntity;

public interface ConcertPayRepository {
    int updateBalance(BalanceEntity balanceEntity);

    int insert(ReservationEntity reservation);
}
