package event.sourcing.eventsourcing.domain.models;

public class MoneyWithdrawnEvent extends Event {
    private double amount;

    public MoneyWithdrawnEvent(String accountId, double amount) {
        super(accountId);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
