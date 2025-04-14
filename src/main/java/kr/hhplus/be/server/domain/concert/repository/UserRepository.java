package domain.concert.repository;

import domain.concert.entity.Balance;

import java.math.BigInteger;

public interface UserRepository {
    Balance getBalance(BigInteger user_id);

    int setBalance(Balance balance);
}
