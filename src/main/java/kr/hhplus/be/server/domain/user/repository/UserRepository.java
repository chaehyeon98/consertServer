package kr.hhplus.be.server.domain.user.repository;

import kr.hhplus.be.server.domain.user.entity.BalanceEntity;

import java.math.BigInteger;

public interface UserRepository {
    BalanceEntity getBalance(BigInteger user_id);

    int setBalance(BalanceEntity balance);
}
