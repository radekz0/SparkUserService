package UserTest1;

public class StandardResponse {
    private StatusResponse statusResponse;
    private User user;

    public StandardResponse(StatusResponse statusResponse, User user){
        this.statusResponse = statusResponse;
        this.user = user;
    }
}
