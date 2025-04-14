package kr.hhplus.be.server.domain.concert.entity;

import java.math.BigInteger;
import java.util.Date;

public class UserEntity {

    private BigInteger user_id;

    private String token;

    private Date token_expiration_time;

    public Date getToken_expiration_time() {
        return token_expiration_time;
    }

    public String getToken() {
        return token;
    }

    public BigInteger getUser_id() {
        return user_id;
    }
}
