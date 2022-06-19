package reservation.service.admin.exception;

public class BusNotFoundException extends RuntimeException {
    public BusNotFoundException(String message) {
        super(message);
    }
}
