package mk.ukim.finki.wp.model;

public class Response {
    private String message;
    private Boolean success;
    private Object entity;


    public Response(String message, Boolean success, Object entity) {
        this.message = message;
        this.success = success;
        this.entity = entity;
    }

    public Response() {
        this.message = null;
        this.success = null;
        this.entity = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
