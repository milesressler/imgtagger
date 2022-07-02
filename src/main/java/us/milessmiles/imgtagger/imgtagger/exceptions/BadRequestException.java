package us.milessmiles.imgtagger.imgtagger.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class BadRequestException extends BaseImgtaggerException {

    public BadRequestException(String message, ErrorCode errorCode, Serializable details) {
        super(message, null, errorCode, details);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
