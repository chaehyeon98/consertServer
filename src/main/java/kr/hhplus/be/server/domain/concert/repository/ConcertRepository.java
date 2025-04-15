package domain.concert.repository;

import domain.concert.entity.Concert;
import domain.concert.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ConcertRepository  extends JpaRepository<Concert, Long> {

    @Query("Select concert_id, concert_name from Concert where concert_name = :name")
    List<Concert> getConcert(@Param("name") String name);

    int insertReservation(Reservation reservation);

}
