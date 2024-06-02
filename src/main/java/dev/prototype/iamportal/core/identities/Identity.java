package dev.prototype.iamportal.core.identities;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.prototype.iamportal.core.abstractions.Entity;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public abstract class Identity extends Entity<IdentityId> {
    @JsonProperty("id")
    private IdentityId id;
    @JsonProperty("metadata_public")
    private MetadataPubic metadataPublic;
    @JsonProperty("metadata_admin")
    private MetadataAdmin metadataAdmin;
    @JsonProperty("state")
    private State state;

    @JsonProperty("nid")
    private UUID nid;
    @JsonProperty("organization_id")
    private UUID organizationId;

    @JsonProperty("state_changed_at")
    private LocalDateTime stateChangedAt;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    public Identity() {}

    public UUID getNid() {
        return nid;
    }

    public void setNid(UUID nid) {
        this.nid = nid;
    }

    @Override
    public IdentityId getId() {
        return id;
    }

    public void setId(IdentityId id) {
        this.id = id;
    }

    public MetadataPubic getMetadataPublic() {
        return metadataPublic;
    }

    public void setMetadataPublic(MetadataPubic metadataPublic) {
        this.metadataPublic = metadataPublic;
    }

    public MetadataAdmin getMetadataAdmin() {
        return metadataAdmin;
    }

    public void setMetadataAdmin(MetadataAdmin metadataAdmin) {
        this.metadataAdmin = metadataAdmin;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public LocalDateTime getStateChangedAt() {
        return stateChangedAt;
    }

    public void setStateChangedAt(LocalDateTime stateChangedAt) {
        this.stateChangedAt = stateChangedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
