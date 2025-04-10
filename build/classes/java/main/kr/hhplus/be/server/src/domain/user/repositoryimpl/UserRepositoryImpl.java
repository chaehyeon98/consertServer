package src.domain.user.repositoryimpl;

import src.domain.user.entity.BalanceEntity;
import src.domain.user.repository.UserRepository;

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
