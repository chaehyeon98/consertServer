package domain.concert.repository;

import domain.concert.entity.Reservation;
import domain.concert.entity.Balance;

public interface ConcertPayRepository {
    int updateBalance(Balance balanceEntity);

    int update(Reservation reservation);
}
