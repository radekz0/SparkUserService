package UserTest1;

import com.google.gson.JsonElement;

public class StandardResponse {
    private StatusResponse status;
    private String message;
    private JsonElement data;

    public StandardResponse(StatusResponse status){
        //..
    }

    public StandardResponse(StatusResponse status, String message){
        //..
    }

    public StandardResponse(StandardResponse status, JsonElement data){
        //...
    }

}
