package kr.hhplus.be.server.domain.concert.service;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.entity.User;

public interface ReservationService {

    Reservation setReservation(ConcertSeat seat, User user);

    void setStatus(Reservation reservation);
}
