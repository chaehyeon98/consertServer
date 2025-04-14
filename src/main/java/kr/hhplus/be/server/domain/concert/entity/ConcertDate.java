package kr.hhplus.be.server.domain.concert.entity;

import java.math.BigInteger;
import java.util.Date;

public class ConcertDate {

    private BigInteger concert_date_id;

    private BigInteger concert_id;

    private Date concert_date;

    public Date getConcert_date() {
        return concert_date;
    }

    public BigInteger getConcert_id() {
        return concert_id;
    }

    public BigInteger getConcert_date_id() {
        return concert_date_id;
    }
}
