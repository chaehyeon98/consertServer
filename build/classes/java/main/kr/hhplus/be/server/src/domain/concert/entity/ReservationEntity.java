package src.domain.concert.entity;

import src.domain.concert.enums.ReservationStatusEnum;

import java.math.BigInteger;

public class ReservationEntity {

    private BigInteger reservation_id;

    private BigInteger seat_id;

    private BigInteger user_id;

    private ReservationStatusEnum status = ReservationStatusEnum.available;

    private BigInteger seat_number;

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
