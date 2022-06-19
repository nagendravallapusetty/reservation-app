package reservation.service.customer.exception;

public class TicketNotAvailableException extends RuntimeException {
    public TicketNotAvailableException(String message) {
        super(message);
    }
}
