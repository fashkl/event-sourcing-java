package event.sourcing.eventsourcing.infrastructure.adapters.inbound.http;

import event.sourcing.eventsourcing.application.usecases.BankAccountUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final BankAccountUseCase bankAccountUseCase;

    public AccountController(BankAccountUseCase bankAccountUseCase) {
        this.bankAccountUseCase = bankAccountUseCase;
    }

    @PostMapping("/create")
    public String createAccount() {
        return bankAccountUseCase.createAccount();
    }

    @PostMapping("/{accountId}/deposit")
    public void deposit(@PathVariable String accountId, @RequestParam double amount) {
        bankAccountUseCase.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable String accountId, @RequestParam double amount) {
        bankAccountUseCase.withdraw(accountId, amount);
    }

    @GetMapping("/{accountId}/balance")
    public double getBalance(@PathVariable String accountId) {
        return bankAccountUseCase.getBalance(accountId);
    }
}
