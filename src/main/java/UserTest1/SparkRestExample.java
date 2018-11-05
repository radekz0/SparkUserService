package UserTest1;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class SparkRestExample {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        //Creating a controller object to access methods such as: addUser, getUsers etc.
        DbController controller = new DbController();

        //For the representation of data JSON structure is used.
        post("/users", (req,res) -> {
            res.type("application/json");   //Type of response headers (Type of the response, in this case json type).
            User user = new Gson().fromJson(req.body(), User.class);    //Body of the request in a Json structure is passed to the user object by Gson().
            // User.class tells Gson to what type json is converted.
            controller.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, user));  //After the user is added Success and user is displayed as a return.
        });

        //Printing all users.
        get("/users", (req,res) -> {
           res.type("application/Json");
           return new Gson().toJson(
                   new StandardResponse(StatusResponse.SUCCESS,
                   new Gson().toJsonTree(controller.getUsers())));
        });

        //Printing user of certain id.
        get("/users/:id", (req,res) -> {
            res.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(controller.getUser(req.params(":id")))));
        });

        //Checking if user exists.
        options("/users/:id", (req,res) ->{
           res.type("application/json");
           return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,(controller.userExist(req.params(":id"))) ? "User exists" : "User does not exist"));
        });

        //Removing user of certain id.
        delete("/users/:id", (req,res) -> {
           res.type("application/json");
           controller.deleteUser(req.params(":id"));
           return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
    }
}