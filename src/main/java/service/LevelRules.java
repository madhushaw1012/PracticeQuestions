package service;

public class LevelRules {

    public void setEarningPercentage(double earningPercentage) {
        this.earningPercentage = earningPercentage;
    }

    public void setSpendingPercentage(double spendingPercentage) {
        this.spendingPercentage = spendingPercentage;
    }

    public void setMaxSpendingAmount(double maxSpendingAmount) {
        this.maxSpendingAmount = maxSpendingAmount;
    }

    double earningPercentage;
    double spendingPercentage;
    double maxSpendingAmount;
    double eligibilityLimit;
    double nextEligibilityLimit;

    public LevelRules(double earningPercentage, double spendingPercentage, double maxSpendingAmount, double eligibilityLimit, double nextEligibilityLimit) {
        this.earningPercentage = earningPercentage;
        this.spendingPercentage = spendingPercentage;
        this.maxSpendingAmount = maxSpendingAmount;
        this.eligibilityLimit = eligibilityLimit;
        this.nextEligibilityLimit = nextEligibilityLimit;
    }

    public double getSpendingPercentage() {
        return spendingPercentage;
    }

    public double getMaxSpendingAmount() {
        return maxSpendingAmount;
    }


    public double getEarningPercentage() {
        return earningPercentage;
    }

    public double getEligibilityLimit() {
        return eligibilityLimit;
    }
    public double getNextEligibilityLimit() {return nextEligibilityLimit;}


    public double calculatePointsEarned(double amount) {
        double pointsEarned = amount/100 * earningPercentage;
        return pointsEarned;
    }

    public double calculateMaxRedeemablePoints(double amount) {
        double maxRedeemablePoints = spendingPercentage * amount/100;
        return Math.min(maxRedeemablePoints, maxSpendingAmount);
    }

    public void setEligibilityLimit(double eligibilityLimit) {
        this.eligibilityLimit = eligibilityLimit;
    }
}
