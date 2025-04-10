package src.domain.concert.entity;

import src.domain.concert.enums.SeatStatusEnum;

import java.math.BigInteger;

public class ConcertSeatEntity {

    private BigInteger seat_id;

    private String concert_date_id;

    private long price;

    private SeatStatusEnum status = SeatStatusEnum.reserved;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public BigInteger getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(BigInteger seat_id) {
        this.seat_id = seat_id;
    }

    public String getConcert_date_id() {
        return concert_date_id;
    }

    public void setConcert_date_id(String concert_date_id) {
        this.concert_date_id = concert_date_id;
    }

    public SeatStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SeatStatusEnum status) {
        this.status = status;
    }
}
