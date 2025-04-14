package domain.concert.repository;

import domain.concert.entity.Reservation;

public interface ReservationRepository {

    int insertReservation(Reservation reservation);
}
