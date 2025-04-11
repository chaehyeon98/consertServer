package src.domain.user.entity;

import src.domain.concert.entity.ConcertSeatEntity;

public class BalanceEntity {

    private long amount;

    private int user_id;

    public BalanceEntity(int user_id, long amount) {
        this.user_id = user_id;
        this.amount = amount;
    }

    public void use(ConcertSeatEntity seatEntity) {

        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        } else if(amount < seatEntity.getPrice()){
            throw new IllegalArgumentException("Amount must be less than or equal to the price");
        }

        amount -= seatEntity.getPrice();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {

        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        this.amount += amount;
    }
}
