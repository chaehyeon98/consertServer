package domain.concert.repository;

import domain.concert.entity.Balance;

public interface UserRepository {
    Balance getBalance(long user_id);

    int setBalance(Balance balance);
}
