package dev.prototype.iamportal.shared.exceptions;

import dev.prototype.iamportal.shared.errors.ErrorDetail;
import dev.prototype.iamportal.shared.errors.ErrorSeverity;
import dev.prototype.iamportal.shared.errors.ErrorType;

import java.util.LinkedList;
import java.util.List;

import static dev.prototype.iamportal.shared.errors.ErrorSeverity.ERROR;
import static dev.prototype.iamportal.shared.errors.ErrorType.INTERNAL_ERROR;

public class AppRuntimeException extends RuntimeException {
    public static final ErrorType DEFAULT_ERROR_TYPE = INTERNAL_ERROR;
    public static final ErrorSeverity DEFAULT_ERROR_SEVERITY = ERROR;

    private final LinkedList<ErrorDetail> errorDetails = new LinkedList<>();
    private ErrorType errorType = DEFAULT_ERROR_TYPE;
    private ErrorSeverity errorSeverity = DEFAULT_ERROR_SEVERITY;

    public AppRuntimeException(String message) {
        super(message);
    }

    public AppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppRuntimeException(String message, ErrorDetail errorDetail) {
        super(message);
        this.errorDetails.add(errorDetail);
    }

    public AppRuntimeException(String message, ErrorDetail errorDetail, Throwable cause) {
        super(message, cause);
        this.errorDetails.add(errorDetail);
    }

    public AppRuntimeException(String message, List<ErrorDetail> errorDetails) {
        super(message);
        this.errorDetails.addAll(errorDetails);
    }

    public AppRuntimeException(String message, List<ErrorDetail> errorDetails, Throwable cause) {
        super(message, cause);
        this.errorDetails.addAll(errorDetails);
    }

    public void addErrorDetails(List<ErrorDetail> errorDetails) {
        this.errorDetails.addAll(errorDetails);
    }

    public void addErrorDetails(ErrorDetail... errorDetails) {
        this.errorDetails.addAll(List.of(errorDetails));
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public ErrorSeverity getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public void setErrorSeverity(ErrorSeverity errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public ErrorDetail getLastErrorDetail() {
        if (errorDetails.isEmpty()) return null;

        return errorDetails.getLast();
    }
}
