package dev.prototype.iamportal.infra.restservices.kratos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record IdentityResponse(
        UUID id,
        @JsonProperty("schema_id")
        String schemaId,
        @JsonProperty("schema_url")
        String schemaUrl,
        @JsonProperty("traits")
        JsonNode traits,
        @JsonProperty("metadata_public")
        JsonNode metadataPublic,
        @JsonProperty("metadata_admin")
        JsonNode metadataAdmin,
        @JsonProperty("state")
        String state,
        @JsonProperty("state_changed_at")
        LocalDateTime stateChangedAt,
        @JsonProperty("created_at")
        LocalDateTime createdAt,
        @JsonProperty("updated_at")
        LocalDateTime updatedAt,
        @JsonProperty("available_aal")
        String availableAal,

        @JsonProperty("credentials")
        JsonNode credentials,

        @JsonProperty("recovery_addresses")
        List<JsonNode> recoveryAddresses,

        @JsonProperty("verifiable_addresses")
        List<JsonNode> verifiableAddresses,

        @JsonProperty("nid")
        UUID nid,
        @JsonProperty("organization_id")
        UUID organizationId
) {
}
