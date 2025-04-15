package domain.concert.serviceimpl;

import domain.concert.entity.Balance;
import domain.concert.repository.UserRepository;
import domain.concert.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public Balance getBalance(long user_id) {
        return userRepository.getBalance(user_id);
    }

    @Override
    public void setBalance(long user_id, long amount) {

        Balance balance = userRepository.getBalance(user_id);

        balance.setAmount(amount);

        if(userRepository.setBalance(balance) <= 0) {
            throw new IllegalArgumentException("잔액 충전 실패");
        }
    }
}
