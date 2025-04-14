package kr.hhplus.be.server.domain.user.repositoryimpl;

import kr.hhplus.be.server.domain.user.entity.BalanceEntity;
import kr.hhplus.be.server.domain.user.repository.UserRepository;

import java.math.BigInteger;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public BalanceEntity getBalance(BigInteger user_id) {
        return null;
    }

    @Override
    public int setBalance(BalanceEntity balance) {
        return 0;
    }
}
