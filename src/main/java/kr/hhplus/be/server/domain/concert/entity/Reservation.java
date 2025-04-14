package domain.concert.entity;

import domain.concert.enums.ReservationStatusEnum;
import domain.concert.enums.SeatStatusEnum;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    private BigInteger reservation_id;

    @JoinColumn(nullable = false)
    private BigInteger seat_id;

    @JoinColumn(nullable = false)
    private BigInteger user_id;

    @Enumerated(EnumType.STRING)
    @Column
    private ReservationStatusEnum status;

    @Column(nullable = false)
    private BigInteger seat_number;

    public Reservation() {

    }

    public Reservation(BigInteger seat_id, BigInteger user_id, BigInteger seat_number, SeatStatusEnum status) {

        if (status == SeatStatusEnum.blocked) {
            throw new IllegalArgumentException("예약 불가");
        } else if(seat_id == null || seat_id.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("seat_id 오류");
        } else if(seat_number == null || seat_number.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("좌석번호 오류");
        }

        this.seat_id = seat_id;
        this.user_id = user_id;
        this.seat_number = seat_number;
        this.status = ReservationStatusEnum.reserved;

    }

    public void setStatus(ReservationStatusEnum status) {
        this.status = status;
    }
    public BigInteger getSeat_id() {
        return seat_id;
    }

}
