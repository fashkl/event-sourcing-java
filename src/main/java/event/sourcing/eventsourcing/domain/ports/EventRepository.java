package event.sourcing.eventsourcing.domain.ports;

import event.sourcing.eventsourcing.domain.models.Event;
import java.util.List;

public interface EventRepository {
    void save(Event event);

    List<Event> getEventsForAccount(String accountId);
}
