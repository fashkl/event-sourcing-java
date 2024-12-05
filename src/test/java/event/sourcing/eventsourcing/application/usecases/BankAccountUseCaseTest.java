package event.sourcing.eventsourcing.application.usecases;

import static org.mockito.Mockito.*;

import event.sourcing.eventsourcing.domain.models.AccountCreatedEvent;
import event.sourcing.eventsourcing.domain.models.MoneyDepositedEvent;
import event.sourcing.eventsourcing.domain.ports.EventRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BankAccountUseCaseTest {

    @Test
    void shouldCreateAccountSuccessfully() {
        EventRepository mockRepository = mock(EventRepository.class);
        BankAccountUseCase useCase = new BankAccountUseCase(mockRepository);

        var accountId = useCase.createAccount();

        verify(mockRepository, times(1)).save(any(AccountCreatedEvent.class));
    }

    @Test
    void shouldDepositMoneySuccessfully() {
        EventRepository mockRepository = mock(EventRepository.class);
        BankAccountUseCase useCase = new BankAccountUseCase(mockRepository);

        useCase.deposit(UUID.randomUUID(), 100.0);

        verify(mockRepository, times(1)).save(any(MoneyDepositedEvent.class));
    }
}
