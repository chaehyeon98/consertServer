package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Concert")
public class Concert {

    @Id
    private long concert_id;

    @Column(nullable = false)
    private String concert_name;


    public Concert(long concert_id, String concert_name) {
        this.concert_id = concert_id;
        this.concert_name = concert_name;
    }

    public Concert() {

    }

    public long getConcert_id() {
        return concert_id;
    }

    public String getConcert_name() {
        return concert_name;
    }
}
