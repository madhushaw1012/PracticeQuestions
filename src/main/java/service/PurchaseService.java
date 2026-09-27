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
    public void purchase(User user, double amount, double points) {
        LevelType levelType = user.getLevelType();
        double maxRedeemablePoints= levelRule.get(levelType).calculateMaxRedeemablePoints(amount);
        System.out.println("Max points redeemable: " + maxRedeemablePoints);
        if(points > user.getPoints()) {
            System.out.println("Get some points first");
            return;
        }
        if(points > maxRedeemablePoints){
            System.out.println("Cant use these many points");
            return;
        }
        double pointsUsed= Math.min(points, maxRedeemablePoints);
        double discountApplied= 0;
        double remainingAmount= amount-pointsUsed-discountApplied;
        double pointsEarned= levelRule.get(levelType).calculatePointsEarned(remainingAmount);
        user.setPoints(user.getPoints() - points +pointsEarned);
        double currentPoints = user.getPoints();
        for(Map.Entry<LevelType, LevelRules> ite:  levelRule.entrySet()) {
            LevelType type = ite.getKey();
            LevelRules levelRule = ite.getValue();
            if (currentPoints >= levelRule.getEligibilityLimit() && currentPoints <= levelRule.getNextEligibilityLimit()) {
                user.setLevelType(type);
                break;
            }
        }

        Purchase order = new Purchase(user, amount, discountApplied,remainingAmount,pointsUsed,pointsEarned);
        List<Purchase> orders= getPurchases(user);
        orders.add(order);
        purchases.put(user, orders);
    }

    public List<Purchase> getPurchases(User user) {
        if(!purchases.containsKey(user)){
            purchases.put(user, new ArrayList<>());
        }
        return  purchases.get(user);
    }

    public Purchase getLastPurchase(User user) {
        List<Purchase> orders= getPurchases(user);
        return orders.get(orders.size()-1);
    }
}
