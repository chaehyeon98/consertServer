package kr.hhplus.be.server.domain.user.repositoryimpl;

import kr.hhplus.be.server.domain.user.entity.Balance;
import kr.hhplus.be.server.domain.user.repository.UserRepository;

import java.math.BigInteger;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Balance getBalance(BigInteger user_id) {
        return null;
    }

    @Override
    public int setBalance(Balance balance) {
        return 0;
    }
}
