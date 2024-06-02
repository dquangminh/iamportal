package dev.prototype.iamportal.shared.mediator;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;

public class MediatorThreadFactory implements ThreadFactory {
    private int counter = 0;

    @Override
    public Thread newThread(@NotNull Runnable runnable) {
        counter++;
        return new Thread(runnable, "MediatorThreadFactory-" + counter);
    }
}
