package kr.hhplus.be.server.domain.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.repository.BalanceRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertPayRepository;
import kr.hhplus.be.server.domain.concert.service.ConcertPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertPayServiceImpl implements ConcertPayService {

    @Autowired
    private ConcertPayRepository concertPayRepository;

    @Autowired
    private BalanceRepository BalanceRepository;

    @Override
    public Balance subtractBalance(User user, ConcertSeat concertSeat) {

        Balance balanceEntity = BalanceRepository.getBalance(user.getUser_id());

        balanceEntity.use(concertSeat);

        if(BalanceRepository.setBalance(balanceEntity.getUser_id(), balanceEntity.getAmount()) <= 0){
            throw new IllegalArgumentException("잔액차감 오류");
        }

        return  balanceEntity;
    }

    @Override
    public void restoreBalance(Balance balance, ConcertSeat concertSeat) {
        balance.setAmount(concertSeat.getPrice());

        if(BalanceRepository.setBalance(balance.getUser_id(), balance.getAmount()) <= 0) {

            throw new IllegalArgumentException("잔액차감 오류");
        }
    }
}
