package UserTest1;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class SparkRestExample {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Service userService = new Service();
        post("/users", (req,res) -> {
            res.type("application/json");
            User user = new Gson().fromJson(req.body(), User.class);
            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

//        get("/users", (req,res) -> {
//           response.type("application/Json");
//           return new Gson().toJson(
//                   new StandardResponse((StatusResponse.SUCCESS,
//                   new Gson()).toJsonTree(userService.getUsers())));
//        });

    }
}
