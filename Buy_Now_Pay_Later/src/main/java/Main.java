import model.Item;
import model.PaymentMethod;
import model.User;
import repository.ItemRepository;
import repository.OrderRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import service.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserRepository userRepository = new UserRepository();
        ItemRepository itemRepository = new ItemRepository();
        OrderRepository orderRepository = new OrderRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        UserService userService = new UserService(userRepository);
        ItemService itemService = new ItemService(itemRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);
        OrderService orderService= new OrderService(userService,transactionService,itemService,orderRepository);
        DuesService duesService = new DuesService(orderService);

        try {
            //seed inventory
            String itemName = "cream";
            int count = 10;
            double price = 100.00;
            Item item = itemService.addItem(itemName, count, price);

            String itemName2 = "paste";
            int count2 = 12;
            double price2 = 15.00;
            Item item2 = itemService.addItem(itemName2, count2, price2);

            //view inventory
            itemService.viewItems();

            //register user
            String userName = "madhu";
            double bnpl_limit = 500.00;
            User user= userService.addUser(userName, bnpl_limit);
            System.out.println("View All Users");
            userService.viewUser(user);

            // purchase
            String userId = "madhu";
            String orderItem = "cream";
            String type= "BNPL";
            PaymentMethod paymentType= type.equals("BNPL")?PaymentMethod.BNPL:PaymentMethod.PREPAID;

            orderService.buy(userId,orderItem,paymentType, LocalDateTime.now());



        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}