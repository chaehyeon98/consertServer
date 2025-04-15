package domain.concert.entity;

import domain.concert.enums.ReservationStatusEnum;
import domain.concert.enums.SeatStatusEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
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

    public Reservation(long seat_id, long user_id, long seat_number, SeatStatusEnum status) {

        if (status == SeatStatusEnum.blocked) {
            throw new IllegalArgumentException("예약 불가");
        } else if(seat_id == 0 || seat_id < 0) {
            throw new IllegalArgumentException("seat_id 오류");
        } else if(seat_number == 0 || seat_number < 0) {
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
    public long getSeat_id() {
        return seat_id;
    }

}
