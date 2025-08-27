package sena.backend.dto;

public class ResponseDTO {
    private String status;
    private String message;

    public ResponseDTO(String ok, String message) {
        this.status = ok;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
