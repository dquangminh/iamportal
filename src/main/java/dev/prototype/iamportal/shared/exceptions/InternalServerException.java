package dev.prototype.iamportal.shared.exceptions;

import dev.prototype.iamportal.shared.errors.ErrorDetail;

import static dev.prototype.iamportal.shared.errors.ErrorSeverity.FATAL;
import static dev.prototype.iamportal.shared.errors.ErrorType.INTERNAL_ERROR;

public class InternalServerException extends AppRuntimeException {
    public InternalServerException(ErrorDetail errorDetail) {
        super(errorDetail.getDescription(), errorDetail);
        setErrorSeverity(FATAL);
        setErrorType(INTERNAL_ERROR);
    }

    public InternalServerException(ErrorDetail errorDetail, Throwable cause) {
        super(errorDetail.getDescription(), errorDetail, cause);
        setErrorSeverity(FATAL);
        setErrorType(INTERNAL_ERROR);
    }
}
