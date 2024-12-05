package event.sourcing.eventsourcing.infrastructure.adapters.outbound.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import event.sourcing.eventsourcing.domain.models.Event;
import event.sourcing.eventsourcing.domain.ports.EventRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class EventStoreRepository implements EventRepository {

    private final EventJpaRepository eventJpaRepository;
    private final ObjectMapper objectMapper;

    public EventStoreRepository(EventJpaRepository eventJpaRepository, ObjectMapper objectMapper) {
        this.eventJpaRepository = eventJpaRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void save(Event event) {
        try {
            EventEntity entity = new EventEntity();
            entity.setAccountId(event.getAccountId());
            entity.setEventType(event.getClass().getSimpleName());
            entity.setEventData(objectMapper.writeValueAsString(event));
            entity.setTimestamp(LocalDateTime.now());
            eventJpaRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save event", e);
        }
    }

    @Override
    public List<Event> getEventsByAccountId(UUID accountId) {
        return eventJpaRepository.findByAccountId(accountId).stream()
                .map(entity -> {
                    try {
                        Class<? extends Event> eventClass = (Class<? extends Event>)
                                Class.forName("event.sourcing.eventsourcing.domain.models." + entity.getEventType());
                        return objectMapper.readValue(entity.getEventData(), eventClass);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to deserialize event", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
