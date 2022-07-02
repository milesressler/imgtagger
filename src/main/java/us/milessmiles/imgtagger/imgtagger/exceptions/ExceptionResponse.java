package us.milessmiles.imgtagger.imgtagger.exceptions;

import com.fasterxml.jackson.databind.JsonSerializable;

import java.io.Serializable;

public class ExceptionResponse {
    private int code;
    private String message;
    private Serializable details;

    public ExceptionResponse(int code, String message, Serializable details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Serializable getDetails() {
        return details;
    }

    public void setDetails(Serializable details) {
        this.details = details;
    }
}
