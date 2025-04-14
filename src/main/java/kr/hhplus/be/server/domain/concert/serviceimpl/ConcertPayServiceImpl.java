package domain.concert.serviceimpl;

import domain.concert.entity.ConcertSeat;
import domain.concert.enums.ReservationStatusEnum;
import domain.concert.repository.ConcertPayRepository;
import domain.concert.entity.Balance;
import domain.concert.repository.UserRepository;
import org.springframework.stereotype.Service;
import domain.concert.service.ConcertPayService;

import domain.concert.entity.Reservation;
import domain.concert.entity.User;

@Service
public class ConcertPayServiceImpl implements ConcertPayService {

    private ConcertPayRepository concertPayRepository;

    private UserRepository userRepository;

    @Override
    public void setStatus(Reservation reservation) {

        //결제/예약 상태변경
        reservation.setStatus(ReservationStatusEnum.paid);

        if(concertPayRepository.update(reservation) <= 0) {

            throw new IllegalArgumentException("결제오류");
        }

    }

    @Override
    public Balance subtractBalance(User user, ConcertSeat concertSeat) {

        Balance balanceEntity = userRepository.getBalance(user.getUser_id());

        concertPayRepository.updateBalance(balanceEntity);

        balanceEntity.use(concertSeat);

        return  balanceEntity;
    }

    @Override
    public void restoreBalance(Balance balance, ConcertSeat concertSeat) {
        balance.setAmount(concertSeat.getPrice());

        if(concertPayRepository.updateBalance(balance) <= 0) {

            throw new IllegalArgumentException("잔액차감 오류");
        }
    }
}
