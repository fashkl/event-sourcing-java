package event.sourcing.eventsourcing.domain.models;

public class MoneyDepositedEvent extends Event {
    private double amount;

    public MoneyDepositedEvent(String accountId, double amount) {
        super(accountId);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
