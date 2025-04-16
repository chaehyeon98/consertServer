package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.ConcertDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertDateRepository extends JpaRepository<ConcertDate, Long> {

    @Query("SELECT concert_date_id, concert_id, concert_date FROM ConcertDate WHERE concert_id = :concert_id")
    List<ConcertDate>  getDate(@Param("concert_id") long concertId);
}
