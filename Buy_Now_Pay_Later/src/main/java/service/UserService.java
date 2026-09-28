package service;

import model.User;
import repository.UserRepository;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, double bnpl_limit) {
        return userRepository.registerUser(name, bnpl_limit);
    }

    public boolean isBlocked(String user) throws Exception {
        return userRepository.isUserBlocked(user);
    }

    public User getUser(String userName) throws Exception {
        return userRepository.getUser(userName);
    }

    public User addUser(String userName, double bnpl_limit) throws Exception {
        return userRepository.addUser(new User(userName, bnpl_limit));
    }

    public void viewUser(User user) throws Exception {
        System.out.println(user.getId()+" : "+user.getBnpl_account()+" : "+user.getBnpl_limit());
    }


}
