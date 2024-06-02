package dev.prototype.iamportal.application.abstractions.messaging;

import dev.prototype.iamportal.shared.mediator.RequestHandler;

public interface QueryHandler<TQuery extends Query, TResponse> extends RequestHandler<TQuery, TResponse> {
}
