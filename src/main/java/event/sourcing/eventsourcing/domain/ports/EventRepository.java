package event.sourcing.eventsourcing.domain.ports;

import event.sourcing.eventsourcing.domain.models.Event;
import java.util.List;
import java.util.UUID;

public interface EventRepository {
    void save(Event event);

    List<Event> getEventsByAccountId(UUID accountId);
}
