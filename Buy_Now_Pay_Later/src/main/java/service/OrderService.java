package service;

import model.*;
import repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;


public class OrderService {
    UserService userService;
    TransactionService trasactionService;
    ItemService itemService;
    PaymentStrategyType paymentStrategyType;
    OrderRepository orderRepository;

    public OrderService(UserService userService, TransactionService trasactionService, ItemService itemService,  OrderRepository orderRepository) {
        this.userService = userService;
        this.trasactionService = trasactionService;
    }

    public Order buy(String name, String item, PaymentMethod paymentMethod, LocalDateTime date) throws Exception{
        try {
            User user = userService.getUser(name);
            System.out.println(user.getId());
            Item i = itemService.getItem(item);
            System.out.println("itemmss"+i.getName());
            if (i.getCount() == 0) throw new Exception("Not enough stock");
            switch (paymentMethod) {
                case PREPAID:
                    paymentStrategyType = new PrepaidPaymentStrategy();
                    break;
                case BNPL:
                    paymentStrategyType = new BNPLPaymentStrategy();
                    break;
            }
            Transaction t = trasactionService.createTransaction(i.getPrice(), user, paymentStrategyType, date);
            trasactionService.addTransaction(t);
            i.setCount(i.getCount() - 1);
            Order order = new Order(user, i, date, paymentStrategyType, t);
            addOrder(order);
            return order;
        } catch (Exception ex) {
            throw new Exception("couldnt buy order");
        }
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public Order getOrder(String orderId) throws Exception{
        return orderRepository.getOrder(orderId);
    }

    public List<Order> getOrders(String user) throws Exception{
        return orderRepository.getOrders(user);
    }
}
