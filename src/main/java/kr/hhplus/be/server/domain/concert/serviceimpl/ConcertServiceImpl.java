package domain.concert.serviceimpl;

import domain.concert.enums.SeatStatusEnum;
import domain.concert.service.ConcertService;
import domain.concert.entity.*;
import domain.concert.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import domain.concert.service.TokenService;

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
    public List<Concert> getConcert(String name) {

        return repo.getConcert(name);
    }

    @Override
    public List<ConcertDate> getDate(BigInteger concertId, User user){

        tokenService.validateToken(user);

        return repo.getDate(concertId);
    }

    @Override
    public List<ConcertSeat> getSeatList(BigInteger concert_date_id, User user) {

        tokenService.validateToken(user);

        return repo.getSeatList(concert_date_id);
    }

    @Override
    public Reservation getReservation(User user, BigInteger seat_id) {

        tokenService.validateToken(user);

        ConcertSeat seat = repo.getSeat(seat_id);

        seat.setStatus(SeatStatusEnum.blocked);

        Reservation reservation = new Reservation(seat.getSeat_id(), user.getUser_id(), seat.getSeat_number(), seat.getStatus());

        if(repo.updateSeat(seat) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        if(repo.insertReservation(reservation) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        return reservation;
    }

    @Override
    public ConcertSeat getConcertSeat(BigInteger seat_id) {
        return repo.getSeat(seat_id);
    }

    @Override
    public void setStatus(ConcertSeat concertSeat) {
        concertSeat.setStatus(SeatStatusEnum.blocked);

        if(repo.updateSeat(concertSeat) <= 0) {

            throw new IllegalArgumentException("좌석상태 변경 오류");
        }
    }
}
