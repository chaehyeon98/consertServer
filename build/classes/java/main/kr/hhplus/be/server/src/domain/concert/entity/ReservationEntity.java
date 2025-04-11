package src.domain.concert.entity;

import src.domain.concert.enums.ReservationStatusEnum;
import src.domain.concert.enums.SeatStatusEnum;

import java.math.BigInteger;

public class ReservationEntity {

    private BigInteger reservation_id;

    private BigInteger seat_id;

    private BigInteger user_id;

    private ReservationStatusEnum status;

    private BigInteger seat_number;

    public ReservationEntity(BigInteger seat_id, BigInteger user_id, BigInteger seat_number, SeatStatusEnum status) {

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

    public BigInteger getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(BigInteger seat_number) {
        this.seat_number = seat_number;
    }

    public ReservationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReservationStatusEnum status) {
        this.status = status;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public BigInteger getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(BigInteger seat_id) {
        this.seat_id = seat_id;
    }

    public BigInteger getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(BigInteger reservation_id) {
        this.reservation_id = reservation_id;
    }
}
