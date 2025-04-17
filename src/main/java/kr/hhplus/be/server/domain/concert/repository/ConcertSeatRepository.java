package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.enums.SeatStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConcertSeatRepository extends JpaRepository<ConcertSeat, Long> {

    @Query("SELECT cs  FROM ConcertSeat cs WHERE cs.concert_date_id = :concert_date_id")
    List<ConcertSeat> getSeatList(@Param("concert_date_id") long concert_date_id);

    @Query("SELECT cs  FROM ConcertSeat cs WHERE cs.seat_id = :seat_id")
    ConcertSeat getSeat(@Param("seat_id")long seat_id);

    @Modifying
    @Transactional
    @Query("UPDATE ConcertSeat cs SET cs.status = :status WHERE cs.seat_id = :seatId")
    int updateSeat(@Param("status") SeatStatusEnum status, @Param("seatId") Long seatId);
}
