package reservation.model.ticket.status;

public class TicketPaymentPending implements TicketStatus {

    private final String value = "payment_pending";

    @Override
    public TicketStatus getSuccessState() {
        return new TicketConfirmed();
    }

    @Override
    public TicketStatus getFailureState() {
        return new TicketFailed();
    }

    @Override
    public String getValue() {
        return value;
    }
}
