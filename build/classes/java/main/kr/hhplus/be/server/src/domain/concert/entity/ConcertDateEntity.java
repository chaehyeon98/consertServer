package src.domain.concert.entity;

import java.math.BigInteger;
import java.util.Date;

public class ConcertDateEntity {

    private BigInteger concert_date_id;

    private BigInteger concert_id;

    private Date concert_date;

    public Date getConcert_date() {
        return concert_date;
    }

    public void setConcert_date(Date concert_date) {
        this.concert_date = concert_date;
    }

    public BigInteger getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(BigInteger concert_id) {
        this.concert_id = concert_id;
    }

    public BigInteger getConcert_date_id() {
        return concert_date_id;
    }

    public void setConcert_date_id(BigInteger concert_date_id) {
        this.concert_date_id = concert_date_id;
    }
}
