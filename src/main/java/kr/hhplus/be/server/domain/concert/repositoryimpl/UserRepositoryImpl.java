package domain.concert.repositoryimpl;

import domain.concert.entity.Balance;
import domain.concert.repository.UserRepository;

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
