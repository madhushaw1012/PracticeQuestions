package service;

import model.LevelType;
import model.Purchase;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseService {

    Map<User, List<Purchase>> purchases;
    Map<LevelType, LevelRules> levelRule;
    public PurchaseService(Map<LevelType, LevelRules> levels) {
        this.purchases = new HashMap<>();
        this.levelRule = levels;
    }
    public Purchase purchase(User user, double amount, double points) {
        LevelType levelType = user.getLevelType();
        double maxRedeemablePoints= levelRule.get(levelType).calculateMaxRedeemablePoints(amount);
        System.out.println("Max points redeemable: " + maxRedeemablePoints);
        if(points > user.getPoints()) {
            System.out.println("Get some points first");
            return null;
        }
        if(points > maxRedeemablePoints){
            System.out.println("Cant use these many points");
            return null;
        }
        double pointsUsed= Math.min(points, maxRedeemablePoints);
        double remainingAmount= amount-pointsUsed;
        double discountApplied= remainingAmount * applyDiscount(user);
        remainingAmount-= discountApplied;
        System.out.println("Discount applied: " + discountApplied);
        System.out.println("Payable amt: " + remainingAmount);

        double pointsEarned= levelRule.get(levelType).calculatePointsEarned(remainingAmount);
        user.setPoints(user.getPoints() - points +pointsEarned);
        double currentPoints = user.getPoints();
        LevelType currentLevelType = determineLevel(currentPoints);
        user.setLevelType(currentLevelType);
        user.setCurrentOrderCount(user.getCurrentOrderCount()+1);

        Purchase order = new Purchase(user, amount, discountApplied,remainingAmount,pointsUsed,pointsEarned);
        List<Purchase> orders= getPurchases(user);
        orders.add(order);
        purchases.put(user, orders);
        return order;
    }

    public List<Purchase> getPurchases(User user) {
        if(!purchases.containsKey(user)){
            purchases.put(user, new ArrayList<>());
        }
        return  purchases.get(user);
    }

    public double totalPurchaseAmount(User user) {
        List<Purchase> orders= getPurchases(user);
        double totalAmount= 0;
        for(Purchase order: orders){
            totalAmount += order.getAmount();
        }
        return totalAmount;
    }

    public LevelType determineLevel(double points) {
        for(Map.Entry<LevelType, LevelRules> ite:  levelRule.entrySet()) {
            LevelType type = ite.getKey();
            LevelRules levelRule = ite.getValue();
            if (points >= levelRule.getEligibilityLimit() && points <= levelRule.getNextEligibilityLimit()) {
                return type;
            }
        }
        return null;
    }
    double calculateDiscount(User user) {
        double discount=0;
        int totalOrders= user.getCurrentOrderCount();
        double totalAmount= totalPurchaseAmount(user);
        if(totalAmount >= 10000 && totalOrders >=3) discount=0.12;
        else if(totalOrders > 3) discount=0.05;
        else if(totalAmount >= 10000) discount=0.1;
        return discount;
    }
    double applyDiscount(User user) {
        double discount= calculateDiscount(user);
        if(discount == 0.12) {
            user.setCurrentOrderCount(0);
        }
        return discount;
    }
}
