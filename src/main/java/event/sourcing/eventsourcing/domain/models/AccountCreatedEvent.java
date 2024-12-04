package event.sourcing.eventsourcing.domain.models;

public class AccountCreatedEvent extends Event {

    public AccountCreatedEvent(String accountId) {
        super(accountId);
    }
}
