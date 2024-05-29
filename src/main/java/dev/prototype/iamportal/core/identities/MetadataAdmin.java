package dev.prototype.iamportal.core.identities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MetadataAdmin() {
}
