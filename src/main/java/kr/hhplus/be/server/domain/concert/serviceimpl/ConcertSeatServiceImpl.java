package domain.concert.serviceimpl;

import domain.concert.entity.ConcertSeat;
import domain.concert.entity.User;
import domain.concert.enums.SeatStatusEnum;
import domain.concert.repository.ConcertSeatRepository;
import domain.concert.service.ConcertSeatService;

import java.math.BigInteger;
import java.util.List;

public class ConcertSeatServiceImpl implements ConcertSeatService {

    ConcertSeatRepository concertSeatRepository;

    @Override
    public List<ConcertSeat> getSeatList(BigInteger concert_date_id) {

        return concertSeatRepository.getSeatList(concert_date_id);
    }

    @Override
    public ConcertSeat getConcertSeat(BigInteger seat_id) {
        return concertSeatRepository.getSeat(seat_id);
    }

    @Override
    public void setStatus(ConcertSeat concertSeat) {

        concertSeat.setStatus(SeatStatusEnum.blocked);

        if(concertSeatRepository.updateSeat(concertSeat) <= 0) {

            throw new IllegalArgumentException("좌석상태 변경 오류");
        }
    }

    @Override
    public ConcertSeat updateSeat(User user, BigInteger seat_id) {

        ConcertSeat seat = concertSeatRepository.getSeat(seat_id);

        seat.setStatus(SeatStatusEnum.blocked);

        if(concertSeatRepository.updateSeat(seat) <= 0){
            throw new IllegalArgumentException("좌석 예약 오류");
        }

        return seat;
    }
}
