package reservation.service.admin.exception;

public class BusAlreadyExistsException extends RuntimeException {
    public BusAlreadyExistsException(String message) {
        super(message);
    }
}
