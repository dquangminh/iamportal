package dev.prototype.iamportal.application.account.GetAccount;

import dev.prototype.iamportal.application.abstractions.messaging.Query;
import dev.prototype.iamportal.shared.mediator.Handler;

import java.util.UUID;

@Handler(handler = GetAccountQueryHandler.class)
public record GetAccountQuery(UUID id) implements Query {

}
