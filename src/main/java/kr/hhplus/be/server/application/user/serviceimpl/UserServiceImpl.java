package kr.hhplus.be.server.application.user.serviceimpl;

import kr.hhplus.be.server.domain.user.entity.Balance;
import kr.hhplus.be.server.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import kr.hhplus.be.server.application.user.service.UserService;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public Balance getBalance(BigInteger user_id) {
        return userRepository.getBalance(user_id);
    }

    @Override
    public void setBalance(BigInteger user_id, long amount) {

        Balance balance = userRepository.getBalance(user_id);

        balance.setAmount(amount);

        if(userRepository.setBalance(balance) <= 0) {
            throw new IllegalArgumentException("잔액 충전 실패");
        }
    }
}
