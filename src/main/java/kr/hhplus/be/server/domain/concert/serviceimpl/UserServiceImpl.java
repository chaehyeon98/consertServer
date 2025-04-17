package kr.hhplus.be.server.domain.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import kr.hhplus.be.server.domain.concert.repository.BalanceRepository;
import kr.hhplus.be.server.domain.concert.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    BalanceRepository userRepository;

    @Override
    public Balance getBalance(long user_id) {
        return userRepository.getBalance(user_id);
    }

    @Override
    public void setBalance(long user_id, long amount) {

        Balance balance = userRepository.getBalance(user_id);

        balance.setAmount(amount);

        if(userRepository.setBalance(balance.getUser_id(), balance.getAmount()) <= 0) {
            throw new IllegalArgumentException("잔액 충전 실패");
        }
    }
}
