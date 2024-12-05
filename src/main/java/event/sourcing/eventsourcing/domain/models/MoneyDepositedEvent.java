package event.sourcing.eventsourcing.domain.models;

import java.util.UUID;
import lombok.Getter;

@Getter
public class MoneyDepositedEvent extends Event {
    private final double amount;

    public MoneyDepositedEvent(UUID accountId, double amount) {
        super(accountId);
        this.amount = amount;
    }
}
