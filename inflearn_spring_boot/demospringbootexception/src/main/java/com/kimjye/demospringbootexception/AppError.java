package com.kimjye.demospringbootexception;

public class AppError {
    private String message;
    private String reasone;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReasone() {
        return reasone;
    }

    public void setReasone(String reasone) {
        this.reasone = reasone;
    }
}
