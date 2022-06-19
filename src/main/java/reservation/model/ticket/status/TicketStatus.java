package reservation.model.ticket.status;

public interface TicketStatus {

    TicketStatus getSuccessState();

    TicketStatus getFailureState();

    String getValue();

}
