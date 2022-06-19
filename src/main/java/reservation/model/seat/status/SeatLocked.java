package reservation.model.seat.status;

public class SeatLocked implements SeatStatus {

    private final String status = "locked";

    @Override
    public SeatStatus next() {
        return new SeatBooked();
    }

    @Override
    public SeatStatus prev() {
        return new SeatAvailable();
    }

    @Override
    public String getValue() {
        return status;
    }
}
