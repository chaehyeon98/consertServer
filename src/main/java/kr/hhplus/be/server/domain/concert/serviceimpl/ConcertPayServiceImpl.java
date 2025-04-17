package kr.hhplus.be.server.domain.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.repository.BalanceRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertPayRepository;
import kr.hhplus.be.server.domain.concert.service.ConcertPayService;
import org.springframework.stereotype.Service;

@Service
public class ConcertPayServiceImpl implements ConcertPayService {

    private ConcertPayRepository concertPayRepository;

    private BalanceRepository userRepository;
    @Override
    public Balance subtractBalance(User user, ConcertSeat concertSeat) {

        Balance balanceEntity = userRepository.getBalance(user.getUser_id());

        concertPayRepository.updateBalance(balanceEntity);

        balanceEntity.use(concertSeat);

        return  balanceEntity;
    }

    @Override
    public void restoreBalance(Balance balance, ConcertSeat concertSeat) {
        balance.setAmount(concertSeat.getPrice());

        if(concertPayRepository.updateBalance(balance) <= 0) {

            throw new IllegalArgumentException("잔액차감 오류");
        }
    }
}
