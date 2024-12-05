package event.sourcing.eventsourcing.infrastructure.adapters.outbound.db;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "events", indexes = @Index(name = "idx_account_id", columnList = "accountId"))
@Getter
@Setter
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID accountId;

    private String eventType;

    @Column(columnDefinition = "TEXT")
    private String eventData;

    private LocalDateTime timestamp;
}
