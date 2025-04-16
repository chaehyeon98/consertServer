package kr.hhplus.be.server.application.concert.Facade;

import kr.hhplus.be.server.domain.concert.entity.Balance;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.service.ConcertPayService;
import kr.hhplus.be.server.domain.concert.service.ConcertSeatService;
import kr.hhplus.be.server.domain.concert.service.ReservationService;
import kr.hhplus.be.server.domain.concert.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertFacade {

    private static final Logger log = LoggerFactory.getLogger(ConcertFacade.class);

    @Autowired
    private ConcertPayService concertPayService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ConcertSeatService concertSeatService;

    @Autowired
    private ReservationService reservationService;

    public void pay(User user, Reservation reservation) {

        //콘서트 좌석조회
        ConcertSeat concertSeat = concertSeatService.getConcertSeat(reservation.getSeat_id());

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
            concertSeatService.setStatus(concertSeat);
            
            //결제/예약 상태변경
            reservationService.setStatus(reservation);
        }catch (Exception e){

            //결제실패시 잔액을 원래대로 되돌림
            concertPayService.restoreBalance(balance, concertSeat);

            throw e;
        }
        
        tokenService.deleteToken(user);

    }

    public List<ConcertSeat> getSeatList(User user, long concert_date_id){
        
        //토큰 검증
        tokenService.validateToken(user);

        //좌석리스트 조회
        return concertSeatService.getSeatList(concert_date_id);
    }

    public Reservation getReservation(User user, long seat_id) {

        //토큰 검증
        tokenService.validateToken(user);

        //좌석 상태변경
        ConcertSeat seat = concertSeatService.updateSeat(user, seat_id);

        //결제/예약 상태변경
        return reservationService.setReservation(seat, user);
    }
}
