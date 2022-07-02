package us.milessmiles.imgtagger.imgtagger.exceptions;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ServiceUnavailableException extends BaseImgtaggerException {

    public ServiceUnavailableException(String message, ErrorCode code, Serializable details) {
        super(message, null, code, details);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_GATEWAY;
    }
}
