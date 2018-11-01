package UserTest1;

import java.util.ArrayList;

public class Service implements UserService {
    //Saving created users in an arrayList for training purposes, later converting to a database connection.
    //UserService has CRUD operations.

    private ArrayList<User> arrayList = new ArrayList<>();
    @Override
    public void addUser(User user) {
        arrayList.add(user);
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        return arrayList;
    }

    @Override
    public boolean userExist(String id) {
        return false;
    }

    @Override
    public void deleteUser(String id) {

    }
}
