package event.sourcing.eventsourcing.application.usecases;

import event.sourcing.eventsourcing.domain.models.Account;
import event.sourcing.eventsourcing.domain.models.AccountCreatedEvent;
import event.sourcing.eventsourcing.domain.models.MoneyDepositedEvent;
import event.sourcing.eventsourcing.domain.ports.EventRepository;
import java.util.UUID;

public class BankAccountUseCase {
    private final EventRepository eventRepository;

    public BankAccountUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public UUID createAccount() {
        var accountId = UUID.randomUUID();
        eventRepository.save(new AccountCreatedEvent(accountId));
        return accountId;
    }

    public void deposit(UUID accountId, double amount) {
        eventRepository.save(new MoneyDepositedEvent(accountId, amount));
    }

    public void withdraw(UUID accountId, double amount) {
        eventRepository.save(new MoneyDepositedEvent(accountId, -amount));
    }

    public double getBalance(UUID accountId) {
        var events = eventRepository.getEventsByAccountId(accountId);
        var account = new Account(events);
        return account.getBalance();
    }
}
