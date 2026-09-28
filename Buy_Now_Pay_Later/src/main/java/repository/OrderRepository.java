package repository;

import model.Order;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    List<Order> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders(String user) {
        return orders.stream()
                .filter(o-> o.getUserId().getId().equals(user))
                .collect(Collectors.toList());
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(String orderId) throws Exception{
        return orders.stream()
                .filter(o-> o.getOrderId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new Exception("Order Id doesn't exist"));

    }
}
