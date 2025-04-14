package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Balance;

import java.math.BigInteger;

public interface UserRepository {
    Balance getBalance(BigInteger user_id);

    int setBalance(Balance balance);
}
