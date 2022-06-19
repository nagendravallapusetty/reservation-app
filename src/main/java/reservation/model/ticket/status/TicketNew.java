package reservation.model.ticket.status;

public class TicketNew implements TicketStatus {

    private final String value = "new";

    @Override
    public TicketStatus getSuccessState() {
        return new TicketPaymentPending();
    }

    @Override
    public TicketStatus getFailureState() {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }
}
