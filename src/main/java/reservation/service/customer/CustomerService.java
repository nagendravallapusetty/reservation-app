package reservation.service.customer;

import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.seat.status.SeatAvailable;
import reservation.model.seat.status.SeatCancelled;
import reservation.model.ticket.Ticket;
import reservation.model.ticket.status.TicketCancelled;
import reservation.model.user.User;
import reservation.service.TicketHandler;
import reservation.service.customer.exception.TicketConfirmException;
import reservation.service.customer.exception.TicketNotAvailableException;
import reservation.service.customer.exception.TicketNotFoundException;
import reservation.service.data.TestData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService implements Customer {

    private volatile static CustomerService customerService;
    private TicketHandler ticketHandler;

    private CustomerService() {
        ticketHandler = TicketHandler.getInstance();
    }

    public static CustomerService getInstance() {

        if (customerService == null) {
            synchronized (CustomerService.class) {
                if (customerService == null) {
                    customerService = new CustomerService();
                }
            }
        }
        return customerService;
    }

    public Ticket cancelTicket(String ticketNumber) {
        Ticket ticket = TestData.getAllTickets().get(ticketNumber);
        if (ticket == null)
            throw new TicketNotFoundException("Invalid ticket number entered");

        ticket.setTicketStatus(ticket.getTicketStatus().getFailureState());
        cancelScheduledSeat(ticket);
        return ticket;
    }

    private boolean cancelScheduledSeat(Ticket ticket) {
        Schedule schedule = ticket.getSchedule();
        ScheduledSeat existingScheduledSeat = ticket.getScheduledSeat();
        ScheduledSeat newScheduledSeat = new ScheduledSeat(existingScheduledSeat.getSeat(), new SeatCancelled(), existingScheduledSeat.getFare());
        schedule.addCancelledSeat(newScheduledSeat);
        existingScheduledSeat.setStatus(new SeatAvailable());
        return true;
    }

    public Ticket trackTicket(String ticketNumber) {
        Ticket ticket = TestData.getAllTickets().get(ticketNumber);
        if (ticket == null)
            throw new TicketNotFoundException("Invalid ticket number entered");

        return ticket;
    }

    public List<ScheduledSeat> getScheduledSeats(Optional<Schedule> schedule) {
        /*List<ScheduledSeat> scheduledSeats = null;
        if (!schedule.isPresent()) {
            scheduledSeats = schedule.get().getReservedSeats().values().stream().filter((scheduledSeat ->
                    scheduledSeat.getStatus().getValue().equalsIgnoreCase("available"))).collect(Collectors.toList());
        }
        return scheduledSeats;*/
        if (schedule.isPresent()) {
            return schedule.get().getReservedSeats();
        }
        return null;
    }


    public Optional<Location> getLocationId(String loc) {
        Optional<Location> returnedLoc = TestData.getAllLocations().stream().filter(
                (location) -> location.getName().toLowerCase().contains(loc.toLowerCase())).findFirst();

        return returnedLoc;
    };

    public List<Location> getAllLocations() {
        return TestData.getAllLocations();
    }

    public List<Schedule> getBuses(Optional<Location> fromLoc, Optional<Location> toLoc, LocalDate date) {

        List<Schedule> schedules = TestData.getAllSchedules();

        List<Schedule> filteredSchedules = schedules.stream().filter((schedule) ->
                schedule.getFromLocation().getLocationId().equals(fromLoc.get().getLocationId())
                        && schedule.getToLocation().getLocationId().equals(toLoc.get().getLocationId()))
                .collect(Collectors.toList());

        return filteredSchedules;
    }

    public Ticket bookTicket(Optional<Schedule> selectedSchedule, Optional<ScheduledSeat> selectedSeat, User user) {
        if (selectedSeat.isPresent()) {
            ScheduledSeat seatSelected = selectedSeat.get();
            if (seatSelected.getStatus().getValue().equalsIgnoreCase(new SeatAvailable().getValue())) {
                synchronized (seatSelected) {
                    System.out.println(" thread name  " + Thread.currentThread().getName() + " " + seatSelected.getStatus().getValue());
                    if (seatSelected.getStatus().getValue().equalsIgnoreCase(new SeatAvailable().getValue())) {
                        seatSelected.setStatus(seatSelected.getStatus().next());
                        //selectedSeatStatus.next(seatSelected);
                        try {
                            Ticket ticket = ticketHandler.generate(selectedSchedule.get(), seatSelected, user);
                            //once ticket is confirmed, update scheduled seat with respective status and ticket
                            seatSelected.setStatus(seatSelected.getStatus().next());
                            seatSelected.setTicket(ticket);
                            return ticket;

                        } catch (Exception e) {
                            seatSelected.setStatus(seatSelected.getStatus().prev());
                            throw new TicketConfirmException("There is some issue while confirming ticket, please try again!");

                        }
                    }
                }
            }
            throw new TicketNotAvailableException("This seat has already been booked by some one, please choose some other seat.");
        }
        return null;
    }




    public List<Ticket> getTickets() {
        return new ArrayList<>(TestData.getAllTickets().values());
    }
}
