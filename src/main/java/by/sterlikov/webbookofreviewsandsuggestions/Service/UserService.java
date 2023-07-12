package by.sterlikov.webbookofreviewsandsuggestions.Service;

import by.sterlikov.webbookofreviewsandsuggestions.Model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user) throws ClassNotFoundException;
    public List<User> printingAllUsers() throws ClassNotFoundException;
    public void dellAllUsers(List<User> users);
}
