package kr.hhplus.be.server.application.user.service;

import kr.hhplus.be.server.domain.user.entity.Balance;

import java.math.BigInteger;

public interface UserService {

    Balance getBalance(BigInteger user_id);

    void setBalance(BigInteger user_id, long amount);
}
