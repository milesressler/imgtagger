package us.milessmiles.imgtagger.imgtagger.exceptions;

public enum ErrorCode {

    IMAGGA_SERVICE_FAILURE(1000),
    IMAGGA_REQUEST_FAILURE(1010),
    IMAGGA_UNEXPECTED_ERROR(1020),
    INTERNAL_EXCEPTION(0),
    OBJECT_NOT_FOUND(10),
    INVALID_INPUT(20);

    public final Integer val;

    private ErrorCode(Integer val) {
        this.val = val;
    }
}
