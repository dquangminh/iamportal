package dev.prototype.iamportal.application.account.GetAccount;

import dev.prototype.iamportal.core.identities.Identity;
import dev.prototype.iamportal.core.identities.schema.Traits;

import java.util.UUID;

public record AccountResponse(
    UUID id,
    Traits traits
) {
    public static AccountResponse from(Identity identity) {
        return new AccountResponse(UUID.randomUUID(), identity.getTraits());
    }
}
