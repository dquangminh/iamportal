package dev.prototype.iamportal.shared.exceptions;

import dev.prototype.iamportal.shared.errors.ErrorDetail;

public class ExternalCallException extends AppRuntimeException {

    public ExternalCallException(String message, ErrorDetail errorDetail) {
        super(message, errorDetail);
    }
}
