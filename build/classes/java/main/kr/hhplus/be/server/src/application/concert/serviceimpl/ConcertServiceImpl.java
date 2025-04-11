package src.application.concert.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.application.concert.service.ConcertService;
import src.application.concert.service.TokenService;
import src.domain.concert.entity.*;
import src.domain.concert.repository.ConcertRepository;

import java.math.BigInteger;
import java.util.List;

@Service
public class ConcertServiceImpl  implements ConcertService {

    @Autowired
    private TokenService tokenService;

    private final ConcertRepository repo;

    public ConcertServiceImpl(ConcertRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ConcertEntity> getConcert(String name) {

        return repo.getConcert(name);
    }

    @Override
    public List<ConcertDateEntity> getDate(BigInteger concertId, UserEntity user){

        tokenService.validateToken(user);

        return repo.getDate(concertId);
    }

    @Override
    public List<ConcertSeatEntity> getSeatList(BigInteger concert_date_id, UserEntity user) {

        tokenService.validateToken(user);

        return repo.getSeatList(concert_date_id);
    }

    @Override
    public ReservationEntity getReservation(UserEntity user, BigInteger seat_id) {

        tokenService.validateToken(user);

        ConcertSeatEntity seat = repo.getSeat(seat_id);

        ReservationEntity reservation = new ReservationEntity(seat.getSeat_id(), user.getUser_id(), seat.getSeat_number(), seat.getStatus());

        if(repo.updateSeat(reservation) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        if(repo.insertReservation(reservation) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        return reservation;
    }
}
