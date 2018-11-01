package UserTest1;

import com.google.gson.JsonElement;

public class StandardResponse {
    private StatusResponse statusResponse;
    private String message;
    private User user;
    private JsonElement jsonElement;

    //We use enum StatusResponse class for receiving a SUCCESS OR ERROR after a CRUD operation
    //StandardResponses are passed to spark's routes (into the callback code).
    public StandardResponse(StatusResponse statusResponse, User user){
        this.statusResponse = statusResponse;
        this.user = user;
    }

    public StandardResponse(StatusResponse statusResponse){
        this.statusResponse = statusResponse;
    }

    public StandardResponse(StatusResponse statusResponse, String message){
        this.statusResponse = statusResponse;
        this.message = message;
    }

    public StandardResponse(StatusResponse statusResponse, JsonElement jsonElement){
        this.statusResponse = statusResponse;
        this.jsonElement = jsonElement;
    }
}