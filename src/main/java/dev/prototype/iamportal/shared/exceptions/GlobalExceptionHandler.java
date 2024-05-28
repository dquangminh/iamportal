package dev.prototype.iamportal.shared.exceptions;

import dev.prototype.iamportal.shared.errors.ErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static dev.prototype.iamportal.shared.errors.ErrorType.CLIENT_ERROR;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String ERROR_ADDITIONAL_INFO_FIELD = "additional_info";
    private static final String STACK_TRACE_FIELD = "stack_trace";

    @ExceptionHandler(NotFoundException.class)
    ProblemDetail handleNotFoundException(NotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        ErrorDetail lastErrorDetail = e.getLastErrorDetail();
        if (lastErrorDetail != null && lastErrorDetail.getAdditionalInfo() != null) {
            problemDetail.setProperty(ERROR_ADDITIONAL_INFO_FIELD, lastErrorDetail.getAdditionalInfo());
        }

        // ThreadContext.put(ERROR_DETAIL, JsonUtil.toString(error.getDetails())
        if (e.getErrorType() != CLIENT_ERROR) {
            log.error("{}", e.getMessage(), e);
        }

        // if profile == DEV, print stack trace

        return problemDetail;
    }

}
