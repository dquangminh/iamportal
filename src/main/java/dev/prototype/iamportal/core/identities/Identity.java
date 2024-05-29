package dev.prototype.iamportal.core.identities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.prototype.iamportal.core.abstractions.Entity;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.core.identities.schema.SchemaId;
import dev.prototype.iamportal.core.identities.schema.Traits;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Identity extends Entity<IdentityId> {
    @JsonProperty("id")
    private IdentityId id;
    @JsonProperty("schema_id")
    private SchemaId schemaId;
    @JsonProperty("traits")
    private Traits traits;
    @JsonProperty("metadata_public")
    private MetadataPubic metadataPublic;
    @JsonProperty("metadata_admin")
    private MetadataAdmin metadataAdmin;
    @JsonProperty("state")
    private State state;
    @JsonProperty("state_changed_at")
    private LocalDateTime stateChangedAt;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty("available_aal")
    private AAL availableAal;

    @JsonProperty("nid")
    private UUID nid;
    @JsonProperty("organization_id")
    private UUID organizationId;

    protected Identity(IdentityId identityId) {
        super(identityId);
    }

    public Identity(SchemaId schemaId, Traits traits, MetadataPubic metadataPublic, MetadataAdmin metadataAdmin, State state, AAL aal) {
        super(IdentityId.NEW_BLANK_ID);
        this.schemaId = schemaId;
        this.traits = traits;
        this.metadataPublic = metadataPublic;
        this.metadataAdmin = metadataAdmin;
        this.state = state;
        this.availableAal = aal;
    }

    public static Result<Identity> create(
        SchemaId schemaId,
        Traits traits,
        MetadataPubic metadataPublic,
        MetadataAdmin metadataAdmin)
    {
        if (schemaId == SchemaId.GUEST) {
            return Result.failure(IdentityErrors.NotEligible);
        }

        var identity = new Identity(
            schemaId,
            traits,
            metadataPublic,
            metadataAdmin,
            State.ACTIVE,
            AAL.AAL1
        );

        return Result.success(identity);
    }
}
