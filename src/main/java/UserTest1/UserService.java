//package UserTest1;
//
//import java.util.ArrayList;
//
//public class UserService implements CrudInterface {
//    //Saving created users in an arrayList for training purposes, later converting to a database connection.
//    //UserService has CRUD operations.
//    private
//    private ArrayList<User> arrayList = new ArrayList<>();
//    @Override
//    public void addUser(User user) {
//
//    }
//
//    @Override
//    public User getUser(String id) {
//        for(User user: arrayList) {
//            if (id.equals(user.getId())) {  //Searching for user by id
//                return user;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<User> getUsers() {
//        return arrayList;
//    }
//
//    @Override
//    public boolean userExist(String id) {
//        for(User user:arrayList){
//            if(id.equals(user.getId())){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void deleteUser(String id) {
//        for(User user:arrayList){
//            if(id.equals(user.getId())){
//                arrayList.remove(user);
//            }
//        }
//    }
//}
