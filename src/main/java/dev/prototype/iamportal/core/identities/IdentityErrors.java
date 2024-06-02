package dev.prototype.iamportal.core.identities;

import dev.prototype.iamportal.core.abstractions.Error;

public class IdentityErrors {
    public static Error NotEligible = new Error(
        10000,
        "Identity.NotEligible",
        "The identity is not eligible because the schema id is not supported now");
    public static Error NotFound = new Error(
            10001,
            "Identity.NotFound",
            "Not found identity"
    );
    public static Error InvalidSchema = new Error(
            10001,
            "Identity.InvalidSchema",
            "Invalid schema"
    );
}
