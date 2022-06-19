package reservation.model.seat.status;

public class SeatAvailable implements SeatStatus {

    private final String status = "available";

    @Override
    public SeatStatus next() {
        return new SeatLocked();
    }

    @Override
    public SeatStatus prev() {
        return new SeatBlocked();
    }

    @Override
    public String getValue() {
        return status;
    }
}
