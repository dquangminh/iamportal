package dev.prototype.iamportal.application.account;

import dev.prototype.iamportal.application.account.GetAccount.AccountResponse;
import dev.prototype.iamportal.application.account.GetAccount.GetAccountQuery;
import dev.prototype.iamportal.application.account.Subscribe.SubscribeCommand;
import dev.prototype.iamportal.core.abstractions.Result;
import dev.prototype.iamportal.shared.mediator.Mediator;
import dev.prototype.iamportal.shared.errors.ErrorDetail;
import dev.prototype.iamportal.shared.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/accounts/guest")
    public Void createGuestAccount() {
        return null;
    }

    @PostMapping("accounts/subscriptions")
    public Void subscribe(@RequestBody SubscribeCommand subscribeCommand) {
        Result<Void> result = mediator.send(subscribeCommand);
        if (result.isFailure()) throw new BadRequestException(ErrorDetail.forError(result.getError()));

        return null;
    }
}
