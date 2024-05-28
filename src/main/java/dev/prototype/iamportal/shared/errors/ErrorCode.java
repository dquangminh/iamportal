package dev.prototype.iamportal.shared.errors;


public enum ErrorCode {
    // Internal Errors
    UNDEFINED_ERROR(1000),
    INTERNAL_ERROR(1001),
    EXTERNAL_CALL_IO_ERROR(1002),
    EXTERNAL_CALL_BAD_RESPONSE_ERROR(1003),

    ;

    private final int code;
    ErrorCode(int code) {
        this.code = code;
    }

    public Integer getCodeAsInt() {
        return code;
    }

    public String getDescription() {
        return "Default description";
    }
}
