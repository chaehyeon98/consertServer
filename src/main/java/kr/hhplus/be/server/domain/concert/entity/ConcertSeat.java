package domain.concert.entity;

import jakarta.persistence.*;
import domain.concert.enums.SeatStatusEnum;

import java.math.BigInteger;

@Entity
@Table(name = "ConcertSeat")
public class ConcertSeat {

    @Id
    private BigInteger seat_id;

    @JoinColumn(nullable = false)
    private String concert_date_id;

    @Column
    private long price;

    @Enumerated(EnumType.STRING)
    @Column
    private SeatStatusEnum status = SeatStatusEnum.available;

    @Column(nullable = false)
    private BigInteger seat_number;

    public ConcertSeat() {

    }

    public ConcertSeat(BigInteger seat_id, String concert_date_id, long price, SeatStatusEnum status, BigInteger seat_number) {
        this.seat_id = seat_id;
        this.concert_date_id = concert_date_id;
        this.price = price;
        this.status = status;
        this.seat_number = seat_number;
    }

    public BigInteger getSeat_number() {
        return seat_number;
    }

    public long getPrice() {
        return price;
    }

    public BigInteger getSeat_id() {
        return seat_id;
    }

    public SeatStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SeatStatusEnum status) {
        this.status = status;
    }
}
