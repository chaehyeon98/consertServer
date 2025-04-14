package kr.hhplus.be.server.domain.user.repository;

import kr.hhplus.be.server.domain.user.entity.Balance;

import java.math.BigInteger;

public interface UserRepository {
    Balance getBalance(BigInteger user_id);

    int setBalance(Balance balance);
}
