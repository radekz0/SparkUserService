package UserTest1;

import java.util.ArrayList;

public interface UserService {
    public void addUser(User user);
    public User getUser(String id);
    public ArrayList<User> getUsers();
    public boolean userExist(String id);
}
