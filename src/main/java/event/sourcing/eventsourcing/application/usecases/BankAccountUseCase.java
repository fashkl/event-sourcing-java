package event.sourcing.eventsourcing.application.usecases;

import event.sourcing.eventsourcing.domain.models.Account;
import event.sourcing.eventsourcing.domain.models.MoneyDepositedEvent;
import event.sourcing.eventsourcing.domain.ports.EventRepository;
import java.util.UUID;

public class BankAccountUseCase {
    private final EventRepository eventRepository;

    public BankAccountUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public String createAccount() {
        String accountId = UUID.randomUUID().toString();
        eventRepository.save(new MoneyDepositedEvent(accountId, 0));
        return accountId;
    }

    public void deposit(String accountId, double amount) {
        eventRepository.save(new MoneyDepositedEvent(accountId, amount));
    }

    public void withdraw(String accountId, double amount) {
        eventRepository.save(new MoneyDepositedEvent(accountId, -amount));
    }

    public double getBalance(String accountId) {
        var events = eventRepository.getEventsForAccount(accountId);
        var account = new Account(events);
        return account.getBalance();
    }
}
