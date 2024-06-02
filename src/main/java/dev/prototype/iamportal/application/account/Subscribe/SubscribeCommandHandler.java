package dev.prototype.iamportal.application.account.Subscribe;

import dev.prototype.iamportal.application.abstractions.messaging.CommandHandler;
import dev.prototype.iamportal.core.abstractions.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscribeCommandHandler implements CommandHandler<SubscribeCommand, Result<Void>> {
    @Override
    public Result<Void> handle(SubscribeCommand subscribeCommand) {
        return null;
    }
}
