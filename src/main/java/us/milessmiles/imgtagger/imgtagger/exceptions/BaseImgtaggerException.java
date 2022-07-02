package us.milessmiles.imgtagger.imgtagger.exceptions;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

abstract public class BaseImgtaggerException extends RuntimeException {

    protected int code;
    protected Serializable details;

    public BaseImgtaggerException(String message, Throwable cause, ErrorCode code, Serializable details) {
        super(message, cause);
        this.code = code.val;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Serializable getDetails() {
        return details;
    }

    public void setDetails(Serializable details) {
        this.details = details;
    }

    abstract public HttpStatus getHttpStatus();

}
