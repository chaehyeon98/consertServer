package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.concert.enums.ReservationStatusEnum;

@Entity
@Table(name = "Reservation", indexes = @Index(name = "idx_reservation_id", columnList = "reservation_id", unique = true))
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservation_id;

    @JoinColumn(nullable = false)
    private long seat_id;

    @JoinColumn(nullable = false)
    private long user_id;

    @Enumerated(EnumType.STRING)
    @Column
    private ReservationStatusEnum status;

    @Column(nullable = false)
    private long seat_number;

    public Reservation() {

    }

    public Reservation(long seat_id, long user_id, long seat_number) {

         if(seat_id == 0 || seat_id < 0) {
            throw new IllegalArgumentException("seat_id 오류");
        } else if(seat_number == 0 || seat_number < 0) {
            throw new IllegalArgumentException("좌석번호 오류");
        }

        this.seat_id = seat_id;
        this.user_id = user_id;
        this.seat_number = seat_number;
        this.status = ReservationStatusEnum.reserved;

    }

    public Reservation(long reservation_id, long seat_id, long user_id, ReservationStatusEnum status, long seat_number) {
        this.reservation_id = reservation_id;
        this.seat_id = seat_id;
        this.user_id = user_id;
        this.status = status;
        this.seat_number = seat_number;
    }

    public void setStatus(ReservationStatusEnum status) {
        this.status = status;
    }
    public long getSeat_id() {
        return seat_id;
    }

    public long getReservation_id() {
        return reservation_id;
    }

    public long getSeat_number() {
        return seat_number;
    }

    public long getUser_id() {
        return user_id;
    }

    public ReservationStatusEnum getStatus() {
        return status;
    }
}
