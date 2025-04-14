package domain.concert.service;

import domain.concert.entity.Balance;

import java.math.BigInteger;

public interface UserService {

    Balance getBalance(BigInteger user_id);

    void setBalance(BigInteger user_id, long amount);
}
