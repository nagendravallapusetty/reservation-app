package reservation.model.ticket.status;

public class TicketConfirmed implements TicketStatus {

    private final String value = "confirmed";

    @Override
    public TicketStatus getSuccessState() {
        return null;
    }

    @Override
    public TicketStatus getFailureState() {
        return new TicketCancelled();
    }

    @Override
    public String getValue() {
        return value;
    }
}
