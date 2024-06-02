package dev.prototype.iamportal.application.account.GetAccount;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.prototype.iamportal.core.identities.SubscriptionType;
import dev.prototype.iamportal.core.identities.State;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static dev.prototype.iamportal.shared.utils.Util.DATETIME_PATTERN;

public record CustomerResponse(
        @JsonProperty("id") UUID id,
        @JsonProperty("account_type") String type,
        @JsonProperty("email") String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("state") State state,
        @JsonFormat(shape = STRING, pattern = DATETIME_PATTERN)
        @JsonProperty("created_at") LocalDateTime createdAt,
        @JsonFormat(shape = STRING, pattern = DATETIME_PATTERN)
        @JsonProperty("updated_at") LocalDateTime updatedAt,
        @JsonProperty("subscriptions") SubscriptionType[] subscriptions,
        @JsonProperty("is_tikier") Boolean isTikier
) implements AccountResponse {
}
