package UserTest1;

public enum StatusResponse {
    //Two option enum for a CRUD status.
    SUCCESS("SUCCESS"),
    ERROR("ERROR");

    private final String status;
    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
