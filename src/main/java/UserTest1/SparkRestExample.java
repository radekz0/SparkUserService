package UserTest1;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class SparkRestExample {
    public static void main(String[] args) {
        BasicConfigurator.configure();

        //Creating a Service object to access methods such as: addUser, getUsers etc.
        Service userService = new Service();

        //For the representation of data JSON structure is used.
        post("/users", (req,res) -> {
            res.type("application/json");   //Type of response headers (Type of the response, in this case json type).
            User user = new Gson().fromJson(req.body(), User.class);    //Body of the request in a Json structure is passed to the user object by Gson().
            // User.class tells Gson to what type json is converted.
            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, user));  //After the user is added Success and user is displayed as a return.
        });

        get("/users", (req,res) -> {
           res.type("application/Json");
           return new Gson().toJson(
                   new StandardResponse(StatusResponse.SUCCESS,
                   new Gson().toJsonTree(userService.getUsers())));
        });
    }
}