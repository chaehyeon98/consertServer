package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    @Id
    private long user_id;

    @Column(nullable = true)
    private String token;

    @Column(nullable = true)
    private Date token_expiration_time;

    public User() {}

    public User(long user_id) {
        this.user_id = user_id;
    }

    public User(long user_id, String token, Date token_expiration_time) {
        this.user_id = user_id;
        this.token = token;
        this.token_expiration_time = token_expiration_time;
    }

    public long getUser_id() {
        return user_id;
    }
}
