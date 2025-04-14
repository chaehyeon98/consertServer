package kr.hhplus.be.server.application.user.service;

import kr.hhplus.be.server.domain.user.entity.BalanceEntity;

import java.math.BigInteger;

public interface UserService {

    BalanceEntity getBalance(BigInteger user_id);

    void setBalance(BigInteger user_id, long amount);
}
