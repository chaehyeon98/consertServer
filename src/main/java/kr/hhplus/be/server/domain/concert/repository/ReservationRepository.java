package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Modifying
    @Query("INSERT INTO Reservation (reservation_id, seat_id, user_id, status, seat_number) " +
            "VALUES (:#{reservation.reservation_id}, :#{reservation.seat_id} , :#{reservation.user_id}" +
            ", :#{reservation.status}, :#{reservation.seat_number})")
    int insertReservation(Reservation reservation);

    @Modifying
    @Query("UPDATE Reservation SET status = :#{reservation.status} WHERE reservation_id = :#{reservation.reservation_id}")
    int update(Reservation reservation);
}
