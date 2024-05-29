package dev.prototype.iamportal.core.abstractions;

public record Error(int codeAsInt, String code, String description) {
    public static Error NONE = new Error(1000, "NONE", "");
    public static Error NotFound = new Error(1001, "NotFound", "");
}
