package kr.hhplus.be.server.application.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeatEntity;
import kr.hhplus.be.server.domain.concert.enums.ReservationStatusEnum;
import kr.hhplus.be.server.domain.concert.repository.ConcertPayRepository;
import kr.hhplus.be.server.domain.concert.repository.ConcertRepository;
import kr.hhplus.be.server.domain.user.entity.BalanceEntity;
import kr.hhplus.be.server.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.hhplus.be.server.application.concert.service.ConcertPayService;
import kr.hhplus.be.server.application.concert.service.TokenService;

import kr.hhplus.be.server.domain.concert.entity.ReservationEntity;
import kr.hhplus.be.server.domain.concert.entity.UserEntity;

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
