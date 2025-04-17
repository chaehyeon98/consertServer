package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.enums.ReservationStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.status = :status WHERE r.reservation_id = :reservation_id")
    int update(@Param("status") ReservationStatusEnum status, @Param("reservation_id") Long reservation_id);
}
