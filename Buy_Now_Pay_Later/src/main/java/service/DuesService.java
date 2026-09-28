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
                    transaction.setDuesState(DuesState.DELAYED);
                } else {
                    transaction.setDuesState(DuesState.CLEARED);
                }
            }
        }
    }

    public void viewDues(String user, LocalDateTime date) throws Exception {
        System.out.println("View Dues");
        List<Order> orders= orderService.getOrders(user);
        for(Order o : orders){
            if(o.getTransaction().getDueDate().isAfter(date) && o.getTransaction().getDuesState() == DuesState.PENDING){
                System.out.println(o.orderId+" | Due Amount: "+o.getTransaction().getPaymentAmount());
            }
        }
    }
}
