package dev.prototype.iamportal.shared.errors;

import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorDetail {
    private String id;
    private Integer code;
    private String description;

    private String additionalInfo;
    private Map<String, Object> parameters;

    public static ErrorDetail forErrorCode(ErrorCode code) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.id = code.name();
        errorDetail.code = code.getCodeAsInt();
        errorDetail.description = code.getDescription();

        return errorDetail;
    }

    public static ErrorDetail forErrorCode(ErrorCode code, String description) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.id = code.name();
        errorDetail.code = code.getCodeAsInt();
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
