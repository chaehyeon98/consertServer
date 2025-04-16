package kr.hhplus.be.server.domain.concert.serviceimpl;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;
import kr.hhplus.be.server.domain.concert.enums.ReservationStatusEnum;
import kr.hhplus.be.server.domain.concert.repository.ReservationRepository;
import kr.hhplus.be.server.domain.concert.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;

    @Override
    public Reservation setReservation(ConcertSeat seat, User user) {
        Reservation reservation = new Reservation(seat.getSeat_id(), user.getUser_id(), seat.getSeat_number(), seat.getStatus());

        if(reservationRepository.insertReservation(reservation) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        return reservation;
    }

    @Override
    public void setStatus(Reservation reservation) {

        //결제/예약 상태변경
        reservation.setStatus(ReservationStatusEnum.paid);

        if(reservationRepository.update(reservation) <= 0) {

            throw new IllegalArgumentException("결제오류");
        }

    }
}
