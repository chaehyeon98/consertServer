package domain.concert.service;


import domain.concert.entity.ConcertSeat;
import domain.concert.entity.Reservation;
import domain.concert.entity.User;
import domain.concert.entity.Balance;

public interface ConcertPayService {

    void setStatus(Reservation reservation);

    Balance subtractBalance(User user, ConcertSeat concertSeat);

    void restoreBalance(Balance balance, ConcertSeat concertSeat);
}
