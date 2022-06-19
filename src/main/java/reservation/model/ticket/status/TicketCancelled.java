package reservation.model.ticket.status;

public class TicketCancelled implements TicketStatus {

    private final String value = "cancelled";

    @Override
    public TicketStatus getSuccessState() {
        return null;
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
