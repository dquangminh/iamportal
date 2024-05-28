package dev.prototype.iamportal.shared.exceptions;


import dev.prototype.iamportal.shared.errors.ErrorDetail;

import java.util.List;

import static dev.prototype.iamportal.shared.errors.ErrorSeverity.WARNING;
import static dev.prototype.iamportal.shared.errors.ErrorType.CLIENT_ERROR;

public class BadRequestException extends AppRuntimeException {
    public BadRequestException(String message, List<ErrorDetail> errorDetails) {
        super(message, errorDetails);
        setErrorSeverity(WARNING);
        setErrorType(CLIENT_ERROR);
    }

    public BadRequestException(ErrorDetail errorDetail) {
        super(errorDetail.getDescription(), errorDetail);
        setErrorSeverity(WARNING);
        setErrorType(CLIENT_ERROR);
    }
}
