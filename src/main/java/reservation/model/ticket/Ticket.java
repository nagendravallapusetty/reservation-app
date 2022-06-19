package reservation.model.ticket;

import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.ticket.status.TicketStatus;
import reservation.model.user.User;

public class Ticket {

    private String ticketId;

    private User user;

    private ScheduledSeat scheduledSeat;

    private Schedule schedule;

    private TicketStatus ticketStatus;

    public Ticket(String ticketId, User user, ScheduledSeat scheduledSeat, Schedule schedule, TicketStatus ticketStatus) {
        this.ticketId = ticketId;
        this.user = user;
        this.scheduledSeat = scheduledSeat;
        this.schedule = schedule;
        this.ticketStatus = ticketStatus;
    }

    public String getTicketId() {
        return ticketId;
    }

    public User getUser() {
        return user;
    }

    public ScheduledSeat getScheduledSeat() {
        return scheduledSeat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public String toString() {
        return "Ticked Id -> " + ticketId + "\n bus number " + schedule.getBus().getBusNumber() +   "\n Seat Id -> " + scheduledSeat.getSeat().getSeatNumber() + "\n From -> " + schedule.getFromLocation().getName()
                + "\n To -> " + schedule.getToLocation().getName() + "\n status " + ticketStatus.getValue();
    }

}
