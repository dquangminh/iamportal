package dev.prototype.iamportal.infra.mediator;

import dev.prototype.iamportal.core.abstractions.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringMediator implements Mediator {

    private final ApplicationContext context;

    @Override
    @SuppressWarnings("unchecked")
    public <TRequest extends Request, TValue, TResponse extends Result<TValue>> TResponse send(TRequest request) {
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

        RequestHandler<TRequest, TValue, Result<TValue>> handler = (RequestHandler<TRequest, TValue, Result<TValue>>) handlerBean;
        return (TResponse) handler.handle(request);
    }
}