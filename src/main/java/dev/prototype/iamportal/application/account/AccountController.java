package dev.prototype.iamportal.application.account;

import dev.prototype.iamportal.application.account.GetAccount.AccountResponse;
import dev.prototype.iamportal.application.account.GetAccount.GetAccountQuery;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.infra.mediator.Mediator;
import dev.prototype.iamportal.shared.errors.ErrorDetail;
import dev.prototype.iamportal.shared.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final Mediator mediator;

    @GetMapping("/accounts/{id}")
    public AccountResponse getById(@PathVariable UUID id) {
        Result<AccountResponse> result = mediator.send(new GetAccountQuery(id));
        if (result.isFailure()) throw new BadRequestException(ErrorDetail.forError(result.getError()));

        return result.getNonNullValue();
    }
}
