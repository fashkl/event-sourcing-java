package event.sourcing.eventsourcing.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Event {
    private UUID accountId;

    public Event(UUID accountId) {
        this.accountId = accountId;
        LocalDateTime timestamp = LocalDateTime.now();
    }
}
