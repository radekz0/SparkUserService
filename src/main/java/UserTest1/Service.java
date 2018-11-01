package UserTest1;

import java.util.ArrayList;

public class Service implements UserService {
    private ArrayList<User> arrayList;
    @Override
    public void addUser(User user) {
        arrayList = new ArrayList<User>();
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
}
