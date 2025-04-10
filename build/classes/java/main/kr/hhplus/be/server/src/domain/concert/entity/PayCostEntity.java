package src.domain.concert.entity;

import java.math.BigInteger;

public class PayCostEntity {

    private BigInteger rcpnum;

    private long amount;

    private int user_id;

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
        this.amount = amount;
    }

    public BigInteger getRcpnum() {
        return rcpnum;
    }

    public void setRcpnum(BigInteger rcpnum) {
        this.rcpnum = rcpnum;
    }
}
