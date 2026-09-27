package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> users;

    public UserService() {
        users= new ArrayList<User>();
    }

    public void addUser(String userId) {
        User user = new User(userId);
        users.add(user);
    }

    public User getUser(String userId) {
        for (User user : users) {
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        System.out.println("User not found, onboarding new");
        return new User(userId);
    }
}
