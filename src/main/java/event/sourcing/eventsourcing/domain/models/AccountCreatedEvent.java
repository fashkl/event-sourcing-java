package event.sourcing.eventsourcing.domain.models;

import java.util.UUID;

public class AccountCreatedEvent extends Event {

    public AccountCreatedEvent(UUID accountId) {
        super(accountId);
    }
}
