package UserTest1;

import java.sql.*;
import java.util.ArrayList;

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
        User foundUser;
        String userId, userName;
        String query = "SELECT * FROM users WHERE id = (?)";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id); //Passing id into (?) in the query.
            ResultSet resultSet = preparedStatement.executeQuery(); //Saving resultSet from a query.

            userId = resultSet.getString(1);
            userName = resultSet.getString(2);
            foundUser = new User(userId,userName);  //Creating a User object to convert it to a Json object.

            return foundUser;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //getUsers() will get the database content, pass it to the resultSet and then each element is saved to an arrayList.
    //ArrayList is converted to a Json object and printed out.
    @Override
    public ArrayList<String> getUsers() {
            String id, name, output;
            ArrayList<String> arrayList = new ArrayList<>();
            String query = "SELECT * FROM users";

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                id = resultSet.getString(1);    //Index 1 is the first column of the table.
                name = resultSet.getString(2);  //Index 2 is the second column of the table.
                output = (id + ": " + name);
                arrayList.add(output);
            }
            return arrayList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean userExist(String id) {
        return false;
    }

    @Override
    public void deleteUser(String id) {

    }

}
