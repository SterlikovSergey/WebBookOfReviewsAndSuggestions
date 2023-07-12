package by.sterlikov.webbookofreviewsandsuggestions.Service;

import by.sterlikov.webbookofreviewsandsuggestions.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    List<User> newUsers = new ArrayList<>();

    @Override
    public void addUser(User user) throws ClassNotFoundException {
        String query = "INSERT INTO USERS(nameUser,messageUser,eMailUser) VALUES (?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_usersMessages";
        String log = "root";
        String password = "root";
        try  (Connection connection = DriverManager.getConnection(url,log,password)){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getMessage() );
            preparedStatement.setString(3,user.getEMail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> printingAllUsers() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_usersMessages";
        String log = "root";
        String password = "root";
        try(Connection connection = DriverManager.getConnection(url,log,password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            while ((resultSet.next())){
                String nameUser;
                String messageUser;
                String eMailUser;
                nameUser = resultSet.getString("nameUser");
                messageUser = resultSet.getString("messageUser");
                eMailUser = resultSet.getString("eMailUser");
                User user = new User(nameUser,eMailUser,messageUser);
                newUsers.add(user);
            }
            return newUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void dellAllUsers(List<User> users) {

    }
}
