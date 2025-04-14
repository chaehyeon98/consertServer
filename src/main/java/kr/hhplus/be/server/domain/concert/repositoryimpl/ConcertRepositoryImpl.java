package domain.concert.repositoryimpl;

import domain.concert.entity.Concert;
import domain.concert.entity.ConcertDate;
import domain.concert.entity.Reservation;
import domain.concert.repository.ConcertRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ConcertRepositoryImpl implements ConcertRepository {
    @Override
    public List<Concert> getConcert(String name) {
        return null;
    }

    @Override
    public List<ConcertDate> getDate(BigInteger concertId) {
        return null;
    }
    @Override
    public int insertReservation(Reservation reservation) {
        return 0;
    }
}
