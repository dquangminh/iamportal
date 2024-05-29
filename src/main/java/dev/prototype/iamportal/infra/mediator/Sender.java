package dev.prototype.iamportal.infra.mediator;

import dev.prototype.iamportal.core.abstractions.Result;

public interface Sender {
    <TRequest extends Request, TValue, TResponse extends Result<TValue>> TResponse send(TRequest request);

}