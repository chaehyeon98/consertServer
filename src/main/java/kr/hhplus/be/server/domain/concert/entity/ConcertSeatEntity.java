package kr.hhplus.be.server.domain.concert.entity;

import kr.hhplus.be.server.domain.concert.enums.SeatStatusEnum;

import java.math.BigInteger;

public class ConcertSeatEntity {

    private BigInteger seat_id;

    private String concert_date_id;

    private long price;

    private SeatStatusEnum status = SeatStatusEnum.available;

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

    public String getConcert_date_id() {
        return concert_date_id;
    }

    public SeatStatusEnum getStatus() {
        return status;
    }
}
