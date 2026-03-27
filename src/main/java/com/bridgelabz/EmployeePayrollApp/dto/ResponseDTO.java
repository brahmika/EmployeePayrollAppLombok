package java.com.bridgelabz.EmployeePayrollApp.dto;

public class ResponseDTO {

    private String message;
    private Object data;

    // Constructor
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    // Getters
    public String getMessage() { return message; }
    public Object getData() { return data; }

    // Setters
    public void setMessage(String message) { this.message = message; }
    public void setData(Object data) { this.data = data; }
}