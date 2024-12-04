package event.sourcing.eventsourcing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import event.sourcing.eventsourcing.domain.models.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void shouldApplyEventsToRebuildAccountState() {
        List<Event> events = List.of(
                new AccountCreatedEvent("123"),
                new MoneyDepositedEvent("123", 100.0),
                new MoneyWithdrawnEvent("123", 50.0));

        Account account = new Account(events);

        assertEquals(50.0, account.getBalance());
    }
}
