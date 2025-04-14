package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;

@Entity
@Table(name = "Concert")
public class Concert {

    @Id
    private BigInteger concert_id;

    @Column(nullable = false)
    private String concert_name;

}
