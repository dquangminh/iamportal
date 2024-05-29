package dev.prototype.iamportal.core.abstractions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Entity<TEntityId> {
    private final List<DomainEvent> _domainEvents = new ArrayList<>();
    private TEntityId id;
    protected Entity(TEntityId id) {
        this.id = id;
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(_domainEvents);
    }
    public void clearDomainEvents() {
        _domainEvents.clear();
    }

    protected void raiseDomainEvent(DomainEvent event) {
        _domainEvents.add(event);
    }
}
