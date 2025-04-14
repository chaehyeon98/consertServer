package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ConcertDate")
public class ConcertDate {

    @Id
    private BigInteger concert_date_id;

    @JoinColumn(nullable = false)
    private BigInteger concert_id;

    @Column(nullable = false)
    private Date concert_date;
}
