package model;

public class Purchase {

    User user;
    double amount;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    public double getCashPaid() {
        return cashPaid;
    }

    public void setCashPaid(double cashPaid) {
        this.cashPaid = cashPaid;
    }

    public double getCoinsRedeemed() {
        return coinsRedeemed;
    }

    public void setCoinsRedeemed(double coinsRedeemed) {
        this.coinsRedeemed = coinsRedeemed;
    }

    public double getCoinsEarned() {
        return coinsEarned;
    }

    public void setCoinsEarned(double coinsEarned) {
        this.coinsEarned = coinsEarned;
    }

    double discountApplied;
    double cashPaid;
    double coinsRedeemed;
    double coinsEarned;

    public Purchase(User user, double amount, double discountApplied, double cashPaid, double coinsRedeemed, double coinsEarned ) {
        this.user = user;
        this.amount = amount;
        this.cashPaid = cashPaid;
        this.coinsRedeemed = coinsRedeemed;
        this.discountApplied= discountApplied;
        this.coinsEarned = coinsEarned;
    }
}
