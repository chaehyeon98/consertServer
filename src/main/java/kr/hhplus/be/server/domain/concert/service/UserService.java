package domain.concert.service;

import domain.concert.entity.Balance;

public interface UserService {

    Balance getBalance(long user_id);

    void setBalance(long user_id, long amount);
}
