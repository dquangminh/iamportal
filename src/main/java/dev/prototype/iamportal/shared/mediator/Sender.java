package dev.prototype.iamportal.shared.mediator;

import java.util.concurrent.CompletableFuture;

public interface Sender {
    /*
    * Synchronously send a request to a single handler
    * */
    <TRequest extends Request, TResponse> TResponse send(TRequest request);

    /*
     * Asynchronously send a request to a single handler
     * */
    <TRequest extends Request, TResponse> CompletableFuture<TResponse> sendAsync(TRequest request);

}