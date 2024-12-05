package event.sourcing.eventsourcing.infrastructure.adapters.outbound.db;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByAccountId(UUID accountId);
}
