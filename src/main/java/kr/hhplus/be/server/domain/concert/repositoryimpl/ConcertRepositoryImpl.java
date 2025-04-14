package kr.hhplus.be.server.domain.concert.repositoryimpl;

import org.springframework.stereotype.Repository;

import kr.hhplus.be.server.domain.concert.entity.ConcertDate;
import kr.hhplus.be.server.domain.concert.entity.Concert;
import kr.hhplus.be.server.domain.concert.entity.ConcertSeat;
import kr.hhplus.be.server.domain.concert.entity.Reservation;
import kr.hhplus.be.server.domain.concert.repository.ConcertRepository;

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
    public List<ConcertSeat> getSeatList(BigInteger concert_date_id) {
        return List.of();
    }

    @Override
    public ConcertSeat getSeat(BigInteger seat_id) {
        return null;
    }

    @Override
    public int insertReservation(Reservation reservation) {
        return 0;
    }

    @Override
    public int updateSeat(Reservation reservation) {
        return 0;
    }
}
