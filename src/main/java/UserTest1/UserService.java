package UserTest1;

import java.util.Collection;

public interface UserService {
    public void addUser(User user);
    public User getUser(String id);
    public Collection<User> getUsers();
    public boolean userExist(String id);
}
