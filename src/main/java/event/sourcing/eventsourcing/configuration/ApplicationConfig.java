package event.sourcing.eventsourcing.configuration;

import event.sourcing.eventsourcing.application.usecases.BankAccountUseCase;
import event.sourcing.eventsourcing.domain.ports.EventRepository;
import event.sourcing.eventsourcing.infrastructure.adapters.outbound.db.EventStoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public BankAccountUseCase bankAccountUseCase(EventRepository eventRepository) {
        return new BankAccountUseCase(eventRepository);
    }

    @Bean
    public EventRepository eventRepository() {
        return new EventStoreRepository();
    }
}
