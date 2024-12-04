package event.sourcing.eventsourcing.domain.models;

import java.util.List;

public class Account {
    private String accountId;
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

    public double getBalance() {
        return balance;
    }
}
