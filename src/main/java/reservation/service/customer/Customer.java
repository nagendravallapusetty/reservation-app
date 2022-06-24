package reservation.service.customer;

import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.ticket.Ticket;
import reservation.model.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Customer {

    Ticket cancelTicket(String ticketNumber);

    Ticket trackTicket(String ticketNumber);

    List<ScheduledSeat> getScheduledSeats(Optional<Schedule> schedule);

    List<Schedule> getBuses(Optional<Location> fromLoc, Optional<Location> toLoc, LocalDate date);

    Ticket bookTicket(Optional<Schedule> selectedSchedule, Optional<ScheduledSeat> selectedSeat, User user);

    List<Ticket> getTickets();
}
