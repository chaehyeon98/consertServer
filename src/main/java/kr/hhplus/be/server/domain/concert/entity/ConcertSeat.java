package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.concert.enums.SeatStatusEnum;

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
}
