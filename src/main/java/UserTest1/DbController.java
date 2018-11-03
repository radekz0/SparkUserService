package UserTest1;

import java.sql.*;

public class DbController implements CrudInterface{
    private Connection connection;
    private PreparedStatement preparedStatement;

    DbController(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Users.db");   //Creating connection to a database.
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user){
        String query = "INSERT INTO users VALUES(?,?)"; //Inserting into already created users table in Users database.
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getId());    //parameterIndex 1 equals first "?" etc.
            preparedStatement.setString(2,user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public void getUsers() {

    }

    @Override
    public boolean userExist(String id) {
        return false;
    }

    @Override
    public void deleteUser(String id) {

    }

}
