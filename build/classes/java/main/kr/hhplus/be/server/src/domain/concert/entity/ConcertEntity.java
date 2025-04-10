package src.domain.concert.entity;

import java.util.Date;

public class ConcertEntity {

    private int user_id;

    private String token;

    public Date getToken_expiration_time() {
        return token_expiration_time;
    }

    public void setToken_expiration_time(Date token_expiration_time) {
        this.token_expiration_time = token_expiration_time;
    }

    private Date token_expiration_time;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


}
