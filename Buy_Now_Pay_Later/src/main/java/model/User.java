package model;

public class User {

    private String id;
    private String bnpl_account;
    private double bnpl_limit;
    private boolean is_blocked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBnpl_limit(double bnpl_limit) {
        this.bnpl_limit = bnpl_limit;
    }

    public User(String id, double bnpl_limit) {
        this.bnpl_limit = bnpl_limit;
        this.id = id;
        bnpl_account = id+"xxx";
        is_blocked = false;
    }

    public String getBnpl_account() {
        return bnpl_account;
    }

    public void setBnpl_account(String bnpl_account) {
        this.bnpl_account = bnpl_account;
    }

    public double getBnpl_limit() {
        return bnpl_limit;
    }
    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }
}
