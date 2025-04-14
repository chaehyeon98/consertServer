package domain.concert.serviceimpl;

import domain.concert.entity.ConcertSeat;
import domain.concert.entity.Reservation;
import domain.concert.entity.User;
import domain.concert.repository.ReservationRepository;
import domain.concert.service.ReservationService;

public class ConcertReservation implements ReservationService {

    ReservationRepository reservationRepository;

    @Override
    public Reservation setReservation(ConcertSeat seat, User user) {
        Reservation reservation = new Reservation(seat.getSeat_id(), user.getUser_id(), seat.getSeat_number(), seat.getStatus());

        if(reservationRepository.insertReservation(reservation) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        return reservation;
    }
}
