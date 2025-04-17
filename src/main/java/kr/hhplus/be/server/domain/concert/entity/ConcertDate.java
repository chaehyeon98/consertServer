package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ConcertDate", indexes = @Index(name = "idx_concert_id", columnList = "concert_id"))
public class ConcertDate {

    @Id
    private long concert_date_id;

    @JoinColumn(nullable = false)
    private long concert_id;

    @Column(nullable = false)
    private Date concert_date;
}
