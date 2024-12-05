package event.sourcing.eventsourcing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import event.sourcing.eventsourcing.domain.models.*;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void shouldApplyEventsToRebuildAccountState() {
        var accountId = UUID.randomUUID();
        List<Event> events = List.of(
                new AccountCreatedEvent(accountId),
                new MoneyDepositedEvent(accountId, 100.0),
                new MoneyWithdrawnEvent(accountId, 50.0));

        Account account = new Account(events);

        assertEquals(50.0, account.getBalance());
    }
}
