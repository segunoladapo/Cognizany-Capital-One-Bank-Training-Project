package com.example.banking.model;

public class GenericRestResponse {
    private String code;
    private String message;
    private String description;
    public GenericRestResponse(String code, String message, String description){
        this.setCode(code);
        this.setMessage(message);
        this.setDescription(description);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
