package event.sourcing.eventsourcing.infrastructure.adapters.inbound.http;

import event.sourcing.eventsourcing.application.usecases.BankAccountUseCase;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final BankAccountUseCase bankAccountUseCase;

    public AccountController(BankAccountUseCase bankAccountUseCase) {
        this.bankAccountUseCase = bankAccountUseCase;
    }

    @PostMapping("/create")
    public UUID createAccount() {
        return bankAccountUseCase.createAccount();
    }

    @PostMapping("/{accountId}/deposit")
    public void deposit(@PathVariable UUID accountId, @RequestParam double amount) {
        bankAccountUseCase.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable UUID accountId, @RequestParam double amount) {
        bankAccountUseCase.withdraw(accountId, amount);
    }

    @GetMapping("/{accountId}/balance")
    public double getBalance(@PathVariable UUID accountId) {
        return bankAccountUseCase.getBalance(accountId);
    }
}
