package kr.hhplus.be.server.domain.concert.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Balance")
public class Balance {

    @Id
    private long user_id;

    @Column(columnDefinition = "MONEY DEFAULT 0")
    private long amount;

    public Balance() {

    }

    public Balance(long user_id, long amount) {
        this.user_id = user_id;
        this.amount = amount;
    }

    public void use(ConcertSeat seatEntity) {

        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        } else if(amount < seatEntity.getPrice()){
            throw new IllegalArgumentException("Amount must be less than or equal to the price");
        }

        amount -= seatEntity.getPrice();
    }

    public void setAmount(long amount) {

        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        this.amount += amount;
    }

    public long getUser_id() {
        return user_id;
    }
}
