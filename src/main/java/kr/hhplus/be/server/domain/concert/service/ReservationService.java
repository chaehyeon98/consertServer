package domain.concert.service;

import domain.concert.entity.ConcertSeat;
import domain.concert.entity.Reservation;
import domain.concert.entity.User;

public interface ReservationService {

    Reservation setReservation(ConcertSeat seat, User user);
}
