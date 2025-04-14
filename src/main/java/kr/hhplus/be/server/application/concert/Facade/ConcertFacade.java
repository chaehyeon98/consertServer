package kr.hhplus.be.server.application.concert.Facade;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.service.ConcertPayService;
import kr.hhplus.be.server.domain.concert.service.ConcertService;
import kr.hhplus.be.server.domain.concert.service.TokenService;
import kr.hhplus.be.server.domain.concert.entity.Balance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertFacade {

    private static final Logger log = LoggerFactory.getLogger(ConcertFacade.class);
    @Autowired
    private ConcertService concertService;

    @Autowired
    private ConcertPayService concertPayService;

    @Autowired
    private TokenService tokenService;

    public void pay(User user, Reservation reservation) {

        //콘서트 좌석조회
        ConcertSeat concertSeat = concertService.getConcertSeat(reservation.getSeat_id());

        //좌석 금액 만큼 차감
        Balance balance = concertPayService.subtractBalance(user, concertSeat);

        //토큰 검증
        try{
            tokenService.validateToken(user);
        }catch (Exception e){

            //검증 실패시 잔액을 원래대로 되돌림
            concertPayService.restoreBalance(balance, concertSeat);

            throw e;
        }

        //결제
        try {
            //좌석 상태변경
            concertService.setStatus(concertSeat);
            
            //결제/예약 상태변경
            concertPayService.setStatus(reservation);
        }catch (Exception e){

            //결제실패시 잔액을 원래대로 되돌림
            concertPayService.restoreBalance(balance, concertSeat);

            throw e;
        }
        
        tokenService.deleteToken(user);

    }
}
