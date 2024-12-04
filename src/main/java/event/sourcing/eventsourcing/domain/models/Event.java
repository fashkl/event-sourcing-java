package event.sourcing.eventsourcing.domain.models;

import java.time.LocalDateTime;

public abstract class Event {
    private String accountId;
    private LocalDateTime timestamp;

    public Event(String accountId) {
        this.accountId = accountId;
        this.timestamp = LocalDateTime.now();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
