package dev.prototype.iamportal.core.identities;

import java.util.UUID;

public record IdentityId(UUID id) {
    public static IdentityId NEW_BLANK_ID = new IdentityId(null);
}
