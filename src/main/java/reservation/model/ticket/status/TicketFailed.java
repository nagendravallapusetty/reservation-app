package reservation.model.ticket.status;

public class TicketFailed implements TicketStatus {

    private final String value = "failed";

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
