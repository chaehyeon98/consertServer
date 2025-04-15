package domain.concert.repository;

import domain.concert.entity.ConcertDate;

import java.util.List;

public interface ConcertDateRepository {

    List<ConcertDate>  getDate(long concertId);
}
