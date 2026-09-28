package service;

import model.DuesState;
import model.Order;
import model.Transaction;
import model.User;

import java.time.LocalDateTime;
import java.util.List;

public class DuesService {

    OrderService orderService;

    public DuesService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void clearDues(User user, List<String> orderId, LocalDateTime date) throws Exception {
        for(String oId : orderId){
            Order order= orderService.getOrder(oId);
            Transaction transaction = order.getTransaction();
            user.setBnpl_limit(user.getBnpl_limit() + transaction.getPaymentAmount());

            if(transaction.getDuesState().equals(DuesState.PENDING)){
                if (!transaction.getDueDate().isBefore(date)) {
                    transaction.setDuesState(DuesState.CLEARED);
                } else {
                    transaction.setDuesState(DuesState.DELAYED);
                }
            }
        }
    }

    public void viewDues(String user, LocalDateTime date) throws Exception {
        List<Order> orders= orderService.getOrders(user);
        for(Order o : orders){
            if(o.getTransaction().getDueDate().isBefore(date) && o.getTransaction().getDuesState().equals(DuesState.PENDING)){
                System.out.println(o.orderId);
            }
        }
    }
}
