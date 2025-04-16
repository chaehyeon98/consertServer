package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertSeatRepository extends JpaRepository<ConcertSeat, Long> {

    @Query("SELECT seat_id, concert_date_id, price, status, seat_number  FROM ConcertSeat WHERE concert_date_id = :concert_date_id")
    List<ConcertSeat> getSeatList(@Param("concert_date_id") long concert_date_id);

    @Query("SELECT seat_id, concert_date_id, price, status, seat_number  FROM ConcertSeat WHERE seat_id = :seat_id")
    ConcertSeat getSeat(@Param("seat_id")long seat_id);

    @Modifying
    @Query("UPDATE ConcertSeat Set status = :#{concertSeat.status} WHERE seat_id = :#{concertSeat.seat_id}")
    int updateSeat(ConcertSeat concertSeat);
}
