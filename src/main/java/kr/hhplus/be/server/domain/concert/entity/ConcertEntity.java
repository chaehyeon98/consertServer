package kr.hhplus.be.server.domain.concert.entity;

import java.math.BigInteger;

public class ConcertEntity {

    private BigInteger concert_id;

    private String concert_name;

    public String getConcert_name() {
        return concert_name;
    }

    public BigInteger getConcert_id() {
        return concert_id;
    }

}
