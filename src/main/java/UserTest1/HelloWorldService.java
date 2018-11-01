package UserTest1;
import org.apache.log4j.BasicConfigurator;
import static spark.Spark.*;

public class HelloWorldService {
    public static void main(String[] args) {

        get("/hello", (req,res) -> "Hello World!");
    }
}
