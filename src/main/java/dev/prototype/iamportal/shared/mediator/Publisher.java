package dev.prototype.iamportal.shared.mediator;

import java.util.concurrent.CompletableFuture;

public interface Publisher {
    /*
     * Asynchronously send a notification to multiple handlers
     * */
    <TNotification extends Request> CompletableFuture<Void> publishAsync(TNotification notification);
}
