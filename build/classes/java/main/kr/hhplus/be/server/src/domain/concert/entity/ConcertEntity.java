package src.domain.concert.entity;

import java.math.BigInteger;

public class ConcertEntity {

    private BigInteger concert_id;

    private String concert_name;

    public String getConcert_name() {
        return concert_name;
    }

    public void setConcert_name(String concert_name) {
        this.concert_name = concert_name;
    }

    public BigInteger getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(BigInteger concert_id) {
        this.concert_id = concert_id;
    }
}
