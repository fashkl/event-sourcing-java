package event.sourcing.eventsourcing.infrastructure.adapters.outbound.db;

import event.sourcing.eventsourcing.domain.models.Event;
import event.sourcing.eventsourcing.domain.ports.EventRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventStoreRepository implements EventRepository {
    private final List<Event> eventStore = new ArrayList<>();

    @Override
    public void save(Event event) {
        eventStore.add(event);
    }

    @Override
    public List<Event> getEventsForAccount(String accountId) {
        return eventStore.stream()
                .filter(event -> event.getAccountId().equals(accountId))
                .collect(Collectors.toList());
    }
}
