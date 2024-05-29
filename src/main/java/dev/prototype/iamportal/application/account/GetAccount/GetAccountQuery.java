package dev.prototype.iamportal.application.account.GetAccount;

import dev.prototype.iamportal.infra.mediator.Handler;
import dev.prototype.iamportal.infra.mediator.Request;

import java.util.UUID;

@Handler(handler = GetAccountQueryHandler.class)
public record GetAccountQuery(UUID id) implements Request {

}
