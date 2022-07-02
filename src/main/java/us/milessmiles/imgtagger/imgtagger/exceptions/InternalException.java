package us.milessmiles.imgtagger.imgtagger.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class InternalException extends BaseImgtaggerException {

    public InternalException(String message, Serializable details) {
        super(message, null, ErrorCode.INTERNAL_EXCEPTION, details);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
