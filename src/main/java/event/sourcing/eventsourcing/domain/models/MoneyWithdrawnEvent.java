package event.sourcing.eventsourcing.domain.models;

import java.util.UUID;
import lombok.Getter;

@Getter
public class MoneyWithdrawnEvent extends Event {
    private final double amount;

    public MoneyWithdrawnEvent(UUID accountId, double amount) {
        super(accountId);
        this.amount = amount;
    }
}
