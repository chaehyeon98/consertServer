package kr.hhplus.be.server.domain.concert.repository;

import kr.hhplus.be.server.domain.concert.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConcertRepository  extends JpaRepository<Concert, Long> {

    @Query("SELECT c FROM Concert c")
    List<Concert> getConcert();

}
