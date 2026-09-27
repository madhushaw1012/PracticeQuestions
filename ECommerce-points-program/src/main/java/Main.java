import model.LevelType;
import model.Purchase;
import model.User;
import service.LevelRules;
import service.PurchaseService;
import service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Config
        Map<LevelType, LevelRules> levels = new HashMap<>();
        LevelRules bronze= new LevelRules(10,5, 200,0, 499);
        LevelRules silver= new LevelRules(12.5,10, 500,500, 999);
        LevelRules gold= new LevelRules(15,15, 1000,1000, 99999);
        levels.put(LevelType.Bronze,bronze);
        levels.put(LevelType.Silver,silver);
        levels.put(LevelType.Gold,gold);
        PurchaseService purchaseService= new PurchaseService(levels);
        UserService userService= new UserService();

        // Flow
        System.out.println("Onboard a user: ");
        String username = sc.nextLine();
        userService.addUser(username);
        System.out.println("User Level: "+ userService.getUser(username).getLevelType());
        System.out.println("User Points: "+ userService.getUser(username).getPoints());
        while(true) {
            System.out.println("Onboard a purchase order: ");
            String pUser= sc.nextLine().trim();
            if(pUser.equals("exit")) break;
            User purchaseUser = userService.getUser(pUser);
            double amount = Double.parseDouble(sc.nextLine().trim());
            double points = Double.parseDouble(sc.nextLine().trim());

            Purchase purchase= purchaseService.purchase(purchaseUser, amount, points);
            System.out.println("Purchase order has been successfully completed");
            if(purchase != null) System.out.println("Coind used: " +purchase.getCoinsRedeemed());
            System.out.println("Current points: "+purchaseUser.getPoints());
            System.out.println("Current level: "+purchaseUser.getLevelType());
        }

    }
}