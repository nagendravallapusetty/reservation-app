package reservation.model.schedule;

import reservation.model.seat.Seat;
import reservation.model.seat.status.SeatStatus;
import reservation.model.ticket.Ticket;

public class ScheduledSeat {

    private Seat seat;

    private SeatStatus status;

    private Ticket ticket;

    private float fare;

    public ScheduledSeat(Seat seat, SeatStatus status, float fare) {
        this.seat = seat;
        this.status = status;
        this.fare = fare;
    }


    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public float getFare() {
        return fare;
    }

    public String toString() {
        return seat.getSeatNumber() + "    " + seat.getSeatType() + "    " +
                (status.getValue().equalsIgnoreCase("available") ? "available" : "unavailable") + " " + fare;
    }
}
