package dev.prototype.iamportal.application.abstractions.messaging;

import dev.prototype.iamportal.shared.mediator.RequestHandler;

public interface CommandHandler<TCommand extends Command, TResponse> extends RequestHandler<TCommand, TResponse> {
}
