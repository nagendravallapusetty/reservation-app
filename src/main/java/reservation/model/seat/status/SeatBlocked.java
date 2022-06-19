package reservation.model.seat.status;


public class SeatBlocked implements SeatStatus {

    private final String status = "blocked";

    @Override
    public SeatStatus next() {
        return new SeatAvailable();
    }

    @Override
    public SeatStatus prev() {
        System.out.println("Can't go back");
        return null;
    }

    @Override
    public String getValue() {
        return status;
    }
}
