package dev.prototype.iamportal.shared.exceptions;

import dev.prototype.iamportal.shared.errors.ErrorDetail;

import static dev.prototype.iamportal.shared.errors.ErrorSeverity.WARNING;
import static dev.prototype.iamportal.shared.errors.ErrorType.CLIENT_ERROR;

public class NotFoundException extends AppRuntimeException {
    public NotFoundException(ErrorDetail errorDetail) {
        super(errorDetail.getDescription(), errorDetail);
        setErrorSeverity(WARNING);
        setErrorType(CLIENT_ERROR);
    }
}
