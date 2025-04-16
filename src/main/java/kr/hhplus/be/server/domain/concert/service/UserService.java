package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.entity.Balance;

public interface UserService {

    Balance getBalance(long user_id);

    void setBalance(long user_id, long amount);
}
