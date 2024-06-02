package dev.prototype.iamportal.core.identities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.core.identities.schema.GuestTraits;
import dev.prototype.iamportal.core.identities.schema.SchemaId;

import java.time.LocalDateTime;
import java.util.UUID;

public class Guest extends Identity {
    @JsonProperty("schema_id")
    private final String schemaId = SchemaId.GUEST;
    @JsonProperty("traits")
    private GuestTraits traits;
    @JsonProperty("available_aal")
    private final AAL availableAal = AAL.aal1;

    public Guest() {
        super();
    }

    private Guest(IdentityId id,
                     GuestTraits traits,
                     MetadataPubic metadataPublic,
                     MetadataAdmin metadataAdmin,
                     State state,
                     UUID nid,
                     UUID organizationId,
                     LocalDateTime stateChangedAt,
                     LocalDateTime createdAt,
                     LocalDateTime updatedAt
    ) {
        super(id, metadataPublic, metadataAdmin, state, nid, organizationId, stateChangedAt, createdAt, updatedAt);
        this.traits = traits;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public GuestTraits getTraits() {
        return traits;
    }

    public void setTraits(GuestTraits traits) {
        this.traits = traits;
    }

    public AAL getAvailableAal() {
        return availableAal;
    }

    public static Result<Guest> create(
            GuestTraits traits,
            MetadataPubic metadataPublic,
            MetadataAdmin metadataAdmin)
    {
        LocalDateTime now = LocalDateTime.now();
        var customer = new Guest(null, traits, metadataPublic, metadataAdmin,
                State.active, null, null, now, now, now);

        return Result.success(customer);
    }
}
