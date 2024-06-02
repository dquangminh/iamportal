package dev.prototype.iamportal.infra.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import dev.prototype.iamportal.core.identities.*;
import dev.prototype.iamportal.core.identities.schema.CustomerTraits;
import dev.prototype.iamportal.core.identities.schema.GuestTraits;
import dev.prototype.iamportal.infra.restservices.kratos.dto.IdentityResponse;
import dev.prototype.iamportal.shared.utils.JsonUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdentityMapper {
    IdentityMapper INSTANCE = Mappers.getMapper(IdentityMapper.class);

    @Named("toMetadataPublic")
    static MetadataPubic toMetadataPublic(JsonNode node) {
        return JsonUtil.treeToValue(node, MetadataPubic.class);
    }

    @Named("toMetadataAdmin")
    static MetadataAdmin toMetadataAdmin(JsonNode node) {
        return JsonUtil.treeToValue(node, MetadataAdmin.class);
    }

    @Named("toCustomerTraits")
    static CustomerTraits toCustomerTraits(JsonNode node) {
        return JsonUtil.treeToValue(node, CustomerTraits.class);
    }

    @Named("toGuestTraits")
    static GuestTraits toGuestTraits(JsonNode node) {
        return JsonUtil.treeToValue(node, GuestTraits.class);
    }

    @Mapping(target = "id", source = "identityId")
    @Mapping(target = "traits", source = "r.traits", qualifiedByName = "toCustomerTraits")
    @Mapping(target = "metadataPublic", source = "r.metadataPublic", qualifiedByName = "toMetadataPublic")
    @Mapping(target = "metadataAdmin", source = "r.metadataAdmin", qualifiedByName = "toMetadataAdmin")
    Customer toCustomer(IdentityResponse r, IdentityId identityId);

    @Mapping(target = "id", source = "identityId")
    @Mapping(target = "traits", source = "r.traits", qualifiedByName = "toGuestTraits")
    @Mapping(target = "metadataPublic", source = "r.metadataPublic", qualifiedByName = "toMetadataPublic")
    @Mapping(target = "metadataAdmin", source = "r.metadataAdmin", qualifiedByName = "toMetadataAdmin")
    Guest toGuest(IdentityResponse r, IdentityId identityId);
}
