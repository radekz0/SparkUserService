package UserTest1;

import java.util.ArrayList;

public interface CrudInterface {
        public void addUser(User user);
        public User getUser(String id);
        public ArrayList<String> getUsers();
        public boolean userExist(String id);
        public void deleteUser(String id);
}
