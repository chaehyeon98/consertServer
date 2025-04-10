package src.domain.user.entity;

public class BalanceEntity {

    private long amount;

    private int user_id;

    public BalanceEntity(int user_id, long amount) {
        this.user_id = user_id;
        this.amount = amount;
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
