package dev.prototype.iamportal.infra.mediator;

import dev.prototype.iamportal.core.abstractions.Result;

public interface RequestHandler<TRequest extends Request, TValue, TResponse extends Result<TValue>> {
    TResponse handle(TRequest tRequest);
}