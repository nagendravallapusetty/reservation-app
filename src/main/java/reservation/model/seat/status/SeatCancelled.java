package reservation.model.seat.status;

public class SeatCancelled implements SeatStatus {

    private final String status = "cancelled";

    @Override
    public SeatStatus next() {
        System.out.println("can't go next");
        return null;
    }

    @Override
    public SeatStatus prev() {
        System.out.println("can't go prev");
        return null;
    }

    @Override
    public String getValue() {
        return status;
    }
}
