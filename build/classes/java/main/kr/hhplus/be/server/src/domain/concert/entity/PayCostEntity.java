package src.domain.concert.entity;

public class PayCostEntity {

    private int rcpnum;

    private String cost_cod;

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

    public String getCost_cod() {
        return cost_cod;
    }

    public void setCost_cod(String cost_cod) {
        this.cost_cod = cost_cod;
    }

    public int getRcpnum() {
        return rcpnum;
    }

    public void setRcpnum(int rcpnum) {
        this.rcpnum = rcpnum;
    }
}
