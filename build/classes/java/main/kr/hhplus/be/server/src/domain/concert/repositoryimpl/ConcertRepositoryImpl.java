package src.domain.concert.repositoryimpl;

import org.springframework.stereotype.Repository;

import src.domain.concert.entity.ConcertDateEntity;
import src.domain.concert.entity.ConcertEntity;
import src.domain.concert.entity.ConcertSeatEntity;
import src.domain.concert.entity.ReservationEntity;
import src.domain.concert.repository.ConcertRepository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ConcertRepositoryImpl implements ConcertRepository {
    @Override
    public List<ConcertEntity> getConcert(String name) {
        return null;
    }

    @Override
    public List<ConcertDateEntity> getDate(BigInteger concertId) {
        return null;
    }

    @Override
    public List<ConcertSeatEntity> getSeatList(BigInteger concert_date_id) {
        return List.of();
    }

    @Override
    public ConcertSeatEntity getSeat(BigInteger seat_id) {
        return null;
    }

    @Override
    public int insertReservation(ReservationEntity reservation) {
        return 0;
    }

    @Override
    public int updateSeat(ReservationEntity reservation) {
        return 0;
    }
}
