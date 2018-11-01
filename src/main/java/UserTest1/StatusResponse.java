package UserTest1;

public enum StatusResponse {
    SUCCESS("SUCCESS2"),
    ERROR("ERROR2");

    private final String status;
    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
