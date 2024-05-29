package dev.prototype.iamportal.shared.errors;

import dev.prototype.iamportal.core.abstractions.Error;
import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorDetail {
    private String code;
    private Integer codeAsInt;
    private String description;

    private String additionalInfo;
    private Map<String, Object> parameters;

    public static ErrorDetail forError(Error error) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.code = error.code();
        errorDetail.codeAsInt = error.codeAsInt();
        errorDetail.description = error.description();

        return errorDetail;
    }

    public static ErrorDetail forError(Error error, String description) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.code = error.code();
        errorDetail.codeAsInt = error.codeAsInt();
        errorDetail.description = description;

        return errorDetail;
    }

    public ErrorDetail setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public ErrorDetail setErrorParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }
}
