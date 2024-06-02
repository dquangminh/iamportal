package dev.prototype.iamportal.application.account.GetAccount;

import dev.prototype.iamportal.application.abstractions.messaging.QueryHandler;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.core.identities.*;
import dev.prototype.iamportal.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static dev.prototype.iamportal.shared.errors.ErrorDetail.forError;

@Component
@RequiredArgsConstructor
public class GetAccountQueryHandler implements QueryHandler<GetAccountQuery, Result<AccountResponse>> {
    private final IdentityRepository identityRepository;

    @Override
    public Result<AccountResponse> handle(GetAccountQuery getAccountQuery) {
        var identity = identityRepository.findById(getAccountQuery.id())
                .orElseThrow(() -> new NotFoundException(forError(IdentityErrors.NotFound)));

        MetadataPubic metadataPubic = identity.getMetadataPublic();
        if (identity instanceof Customer customer) {

            return Result.success(new CustomerResponse(
                    customer.getId().id(),
                    customer.getSchemaId(),
                    customer.getTraits().email(),
                    customer.getTraits().phone(),
                    customer.getTraits().name().first(),
                    customer.getTraits().name().last(),
                    customer.getState(),
                    customer.getStateChangedAt(),
                    customer.getCreatedAt(),
                    metadataPubic != null ? metadataPubic.subscriptions() : null,
                    metadataPubic != null ? metadataPubic.isTikier() : null)
            );
        } else if (identity instanceof Guest guest) {

            return Result.success(new GuestResponse(
                    guest.getId().id(),
                    guest.getSchemaId(),
                    guest.getTraits().name().first(),
                    guest.getTraits().name().last(),
                    guest.getState(),
                    guest.getStateChangedAt(),
                    guest.getCreatedAt(),
                    metadataPubic != null ? metadataPubic.subscriptions() : null)
            );
        }

        return Result.failure(IdentityErrors.InvalidSchema);
    }
}
