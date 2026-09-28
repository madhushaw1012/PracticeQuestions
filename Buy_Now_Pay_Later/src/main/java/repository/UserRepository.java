package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }
    public List<User> getUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }
    public User registerUser(String name, double limit) {
        User user = new User(name, limit);
        users.add(user);
        return user;
    }

    public User getUser(String name) throws Exception {
        return users.stream()
                .filter(u -> u.getId().equals(name))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("User with name " + name + " not found"));
    }

    public void blockUser(String name) throws Exception {
        User user= getUser(name);
        user.setIs_blocked(true);
    }

    public boolean isUserBlocked(String name) throws Exception {
        User user= getUser(name);
        return user.isIs_blocked();
    }
}
