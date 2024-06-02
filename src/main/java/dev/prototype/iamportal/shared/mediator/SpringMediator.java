package dev.prototype.iamportal.shared.mediator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringMediator implements Mediator {
    private final Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new MediatorThreadFactory());

    private final ApplicationContext context;

    @Override
    public <TRequest extends Request, TResponse> TResponse send(TRequest request) {
        RequestHandler<TRequest, TResponse> handler = getRequestHandler(request);
        log.debug("Sending synchronously request class {} to handler class {}", request.getClass(), handler.getClass());
        return handler.handle(request);
    }

    @SuppressWarnings("unchecked")
    private <TRequest extends Request, TResponse> RequestHandler<TRequest, TResponse> getRequestHandler(TRequest request) {
        if (request == null) {
            throw new NullPointerException("The given request cannot be null");
        }

        Handler handlerAnnotation = request.getClass().getAnnotation(Handler.class);

        if (handlerAnnotation == null) {
            throw new IllegalArgumentException("Handler @Annotation not found for request class " + request.getClass().getName());
        }

        Class<?> requestHandler = handlerAnnotation.handler();
        Object handlerBean = context.getBean(requestHandler);

        if (!(handlerBean instanceof RequestHandler)) {
            throw new IllegalArgumentException("Handler Bean does not implement RequestHandler interface " + requestHandler.getName());
        }

        return (RequestHandler<TRequest, TResponse>) handlerBean;
    }

    @Override
    public <TRequest extends Request, TResponse> CompletableFuture<TResponse> sendAsync(TRequest request) {
        RequestHandler<TRequest, TResponse> handler = getRequestHandler(request);
        log.debug("Sending asynchronously request class {} to handler class {}", request.getClass(), handler.getClass());

        return CompletableFuture.supplyAsync(() -> handler.handle(request), executor);
    }
}