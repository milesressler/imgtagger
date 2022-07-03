package us.milessmiles.imgtagger.imgtagger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private ResponseEntity<ExceptionResponse> handleExceptionInternal(BaseImgtaggerException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getCode(), ex.getMessage(), ex.getDetails());
        return new ResponseEntity<>(
                response,
                ex.getHttpStatus());
    }

    @ExceptionHandler(value = BaseImgtaggerException.class)
    public ResponseEntity<ExceptionResponse> exception(BaseImgtaggerException exception) {
        return handleExceptionInternal(exception);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ExceptionResponse> exception(ValidationException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(ErrorCode.GENERAL_VALIDATION.val, exception.getMessage(), null),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponse> exception(RuntimeException exception) {
        exception.printStackTrace();
        return handleExceptionInternal(new InternalException("Unexpected Error", null));
    }
}
