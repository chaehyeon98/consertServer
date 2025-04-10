package src.domain.user.repository;

import src.domain.user.entity.BalanceEntity;

import java.math.BigInteger;

public interface UserRepository {
    BalanceEntity getBalance(BigInteger user_id);

    int setBalance(BalanceEntity balance);
}
