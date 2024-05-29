package dev.prototype.iamportal.application.account.GetAccount;

import dev.prototype.iamportal.core.abstractions.Error;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.core.identities.IdentityRepository;
import dev.prototype.iamportal.infra.mediator.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAccountQueryHandler implements RequestHandler<GetAccountQuery, AccountResponse, Result<AccountResponse>> {
    private final IdentityRepository identityRepository;

    @Override
    public Result<AccountResponse> handle(GetAccountQuery getAccountQuery) {
        return identityRepository.findById(getAccountQuery.id())
            .map(identity -> Result.success(AccountResponse.from(identity)))
            .orElse(Result.failure(Error.NotFound));
    }
}
