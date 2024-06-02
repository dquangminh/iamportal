package dev.prototype.iamportal.core.identities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.core.identities.schema.CustomerTraits;
import dev.prototype.iamportal.core.identities.schema.SchemaId;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer extends Identity {
    @JsonProperty("schema_id")
    private final String schemaId = SchemaId.CUSTOMER;
    @JsonProperty("traits")
    private CustomerTraits traits;
    @JsonProperty("available_aal")
    private AAL availableAal;

    public Customer() {
        super();
    }

    private Customer(IdentityId id,
                     CustomerTraits traits,
                     MetadataPubic metadataPublic,
                     MetadataAdmin metadataAdmin,
                     State state,
                     AAL availableAal,
                     UUID nid,
                     UUID organizationId,
                     LocalDateTime stateChangedAt,
                     LocalDateTime createdAt,
                     LocalDateTime updatedAt
                     ) {
        super(id, metadataPublic, metadataAdmin, state, nid, organizationId, stateChangedAt, createdAt, updatedAt);
        this.traits = traits;
        this.availableAal = availableAal;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public CustomerTraits getTraits() {
        return traits;
    }

    public void setTraits(CustomerTraits traits) {
        this.traits = traits;
    }

    public AAL getAvailableAal() {
        return availableAal;
    }

    public void setAvailableAal(AAL availableAal) {
        this.availableAal = availableAal;
    }

    public static Result<Customer> create(
            CustomerTraits traits,
            MetadataPubic metadataPublic,
            MetadataAdmin metadataAdmin,
            AAL aal)
    {
        LocalDateTime now = LocalDateTime.now();
        var customer = new Customer(null, traits, metadataPublic, metadataAdmin,
                State.active, AAL.aal1, null, null, now, now, now);

        return Result.success(customer);
    }
}
