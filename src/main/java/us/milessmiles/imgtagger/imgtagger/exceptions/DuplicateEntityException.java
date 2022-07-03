package us.milessmiles.imgtagger.imgtagger.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class DuplicateEntityException extends BaseImgtaggerException {

    public DuplicateEntityException(String entityType, Serializable details) {
        super(String.format("%s already exists with the provided details.", entityType), null, ErrorCode.DUPLICATE_OBJECT, details);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}
