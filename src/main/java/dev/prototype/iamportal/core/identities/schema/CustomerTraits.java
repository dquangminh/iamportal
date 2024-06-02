package dev.prototype.iamportal.core.identities.schema;

public record CustomerTraits(
    String email,
    String phone,
    NameProperties name
) implements Traits {
}

