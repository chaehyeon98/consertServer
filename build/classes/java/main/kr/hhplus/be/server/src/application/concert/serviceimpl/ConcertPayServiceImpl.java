package src.application.concert.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.application.concert.service.ConcertPayService;
import src.application.concert.service.TokenService;
import src.domain.concert.entity.ConcertSeatEntity;
import src.domain.concert.entity.ReservationEntity;
import src.domain.concert.entity.UserEntity;
import src.domain.concert.enums.ReservationStatusEnum;
import src.domain.concert.repository.ConcertPayRepository;
import src.domain.concert.repository.ConcertRepository;
import src.domain.user.entity.BalanceEntity;
import src.domain.user.repository.UserRepository;

@Service
public class ConcertPayServiceImpl implements ConcertPayService {

    @Autowired
    private TokenService tokenService;

    private UserRepository userRepository;

    private ConcertPayRepository concertPayRepository;

    private ConcertRepository concertRepository;

    @Override
    public ReservationEntity pay(UserEntity user, ReservationEntity reservation) {

        ConcertSeatEntity concertSeatEntity = concertRepository.getSeat(reservation.getSeat_id());

        BalanceEntity balanceEntity = userRepository.getBalance(user.getUser_id());

        concertPayRepository.updateBalance(balanceEntity);

        balanceEntity.use(concertSeatEntity);

        try{
            tokenService.validateToken(user);
        }catch (Exception e){

            balanceEntity.setAmount(concertSeatEntity.getPrice());

            concertPayRepository.updateBalance(balanceEntity);

            throw e;
        }

        reservation.setStatus(ReservationStatusEnum.paid);

        if(concertPayRepository.insert(reservation) <= 0){

            balanceEntity.setAmount(concertSeatEntity.getPrice());

            concertPayRepository.updateBalance(balanceEntity);

            throw new IllegalArgumentException("결제오류");

        }

        tokenService.deleteToken(user);

        return reservation;
    }
}
