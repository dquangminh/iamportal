package dev.prototype.iamportal.shared.mediator;

public interface RequestHandler<TRequest extends Request, TResponse> {
    TResponse handle(TRequest tRequest);
}