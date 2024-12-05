package event.sourcing.eventsourcing.domain.models;

import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Account {
    private UUID accountId;
    private double balance;

    public Account(List<Event> events) {
        events.forEach(this::apply);
    }

    public void apply(Event event) {
        if (event instanceof AccountCreatedEvent) {
            this.accountId = event.getAccountId();
        } else if (event instanceof MoneyDepositedEvent moneyDepositedEvent) {
            deposit(moneyDepositedEvent.getAmount());
        } else if (event instanceof MoneyWithdrawnEvent moneyWithdrawnEvent) {
            withdraw(moneyWithdrawnEvent.getAmount());
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
