package reservation.model.seat.status;

public interface SeatStatus {

    SeatStatus next();

    SeatStatus prev();

    String getValue();

}
