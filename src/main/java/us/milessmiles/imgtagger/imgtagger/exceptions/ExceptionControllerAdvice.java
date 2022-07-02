package us.milessmiles.imgtagger.imgtagger.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import us.milessmiles.imgtagger.imgtagger.exceptions.BaseImgtaggerException;
import us.milessmiles.imgtagger.imgtagger.exceptions.ErrorCode;
import us.milessmiles.imgtagger.imgtagger.exceptions.ExceptionResponse;
import us.milessmiles.imgtagger.imgtagger.exceptions.ServiceUnavailableException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private ResponseEntity<ExceptionResponse> handleExceptionInternal(BaseImgtaggerException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getCode(), ex.getMessage(),ex.getDetails());
        return new ResponseEntity<>(
                response,
                ex.getHttpStatus());
    }

    @ExceptionHandler(value = BaseImgtaggerException.class)
    public ResponseEntity<ExceptionResponse> exception(BaseImgtaggerException exception) {
        return handleExceptionInternal(exception);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponse> exception(RuntimeException exception) {
        exception.printStackTrace();
        return handleExceptionInternal(new InternalException("Unexpected Error", null));
    }
}
