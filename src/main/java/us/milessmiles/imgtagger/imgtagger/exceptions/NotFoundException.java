package us.milessmiles.imgtagger.imgtagger.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class NotFoundException extends BaseImgtaggerException {

    public NotFoundException(String message, ErrorCode errorCode, Serializable details) {
        super(message, null, errorCode, details);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
