package domain.concert.entity;

import domain.concert.enums.SeatStatusEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "ConcertSeat")
public class ConcertSeat {

    @Id
    private long seat_id;

    @JoinColumn(nullable = false)
    private long concert_date_id;

    @Column
    private long price;

    @Enumerated(EnumType.STRING)
    @Column
    private SeatStatusEnum status = SeatStatusEnum.available;

    @Column(nullable = false)
    private long seat_number;

    public ConcertSeat() {

    }

    public ConcertSeat(long seat_id, long concert_date_id, long price, SeatStatusEnum status, long seat_number) {
        this.seat_id = seat_id;
        this.concert_date_id = concert_date_id;
        this.price = price;
        this.status = status;
        this.seat_number = seat_number;
    }

    public long getSeat_number() {
        return seat_number;
    }

    public long getPrice() {
        return price;
    }

    public long getSeat_id() {
        return seat_id;
    }

    public SeatStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SeatStatusEnum status) {
        this.status = status;
    }
}
