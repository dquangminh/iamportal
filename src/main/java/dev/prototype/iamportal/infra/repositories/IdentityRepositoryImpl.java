package dev.prototype.iamportal.infra.repositories;

import dev.prototype.iamportal.core.identities.*;
import dev.prototype.iamportal.core.identities.schema.SchemaId;
import dev.prototype.iamportal.infra.restservices.kratos.KratosClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class IdentityRepositoryImpl implements IdentityRepository {
    private final KratosClient kratosClient;

    @Override
    public Optional<Identity> findById(UUID id) {
        return kratosClient.getIdentity(id)
                .map((r) -> switch (r.schemaId()) {
                    case SchemaId.CUSTOMER, SchemaId.DEFAULT ->
                            IdentityMapper.INSTANCE.toCustomer(r, new IdentityId(r.id()));
                    case SchemaId.GUEST -> IdentityMapper.INSTANCE.toGuest(r, new IdentityId(r.id()));
                    default -> null;
                });
    }
}
