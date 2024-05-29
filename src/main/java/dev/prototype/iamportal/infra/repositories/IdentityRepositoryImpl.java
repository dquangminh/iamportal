package dev.prototype.iamportal.infra.repositories;

import dev.prototype.iamportal.core.identities.Identity;
import dev.prototype.iamportal.core.identities.IdentityRepository;
import dev.prototype.iamportal.core.identities.MetadataAdmin;
import dev.prototype.iamportal.core.identities.MetadataPubic;
import dev.prototype.iamportal.core.identities.schema.CustomerTraits;
import dev.prototype.iamportal.core.identities.schema.SchemaId;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class IdentityRepositoryImpl implements IdentityRepository {
    @Override
    public Optional<Identity> findById(UUID id) {
        return Identity.create(SchemaId.CUSTOMER, new CustomerTraits(), new MetadataPubic(new String[]{"customer"}, false), new MetadataAdmin()).getValue();
    }
}
