package dev.prototype.iamportal.application.account.Subscribe;

import dev.prototype.iamportal.application.abstractions.messaging.Command;
import dev.prototype.iamportal.core.identities.SubscriptionType;
import dev.prototype.iamportal.shared.mediator.Handler;

@Handler(handler = SubscribeCommandHandler.class)
public record SubscribeCommand(SubscriptionType type) implements Command {

}
