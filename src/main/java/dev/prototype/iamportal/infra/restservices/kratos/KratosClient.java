package dev.prototype.iamportal.infra.restservices.kratos;

import dev.prototype.iamportal.infra.restservices.kratos.dto.IdentityResponse;

import java.util.Optional;
import java.util.UUID;

public interface KratosClient {
    Optional<IdentityResponse> getIdentity(UUID id);
}
