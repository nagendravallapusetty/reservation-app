package reservation.controller.customer;

import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.ticket.Ticket;
import reservation.model.user.User;
import reservation.service.customer.CustomerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CustomerController {

    private volatile static CustomerController customerController;
    private final CustomerService customerService;

    private CustomerController() {
        customerService = CustomerService.getInstance();
    }

    public static CustomerController getInstance() {

        if (customerController == null) {
            synchronized (CustomerController.class) {
                if (customerController == null) {
                    customerController = new CustomerController();
                }
            }
        }
        return customerController;
    }


    public Ticket cancelTicket(String ticketNumber) {
        return customerService.cancelTicket(ticketNumber);
    }

    public Ticket trackTicket(String ticketNumber) {
        return customerService.trackTicket(ticketNumber);
    }


    public List<ScheduledSeat> getScheduledSeats(Optional<Schedule> schedule) {
        return customerService.getScheduledSeats(schedule);
    }

    public List<Schedule> getBuses(Optional<Location> fromLoc, Optional<Location> toLoc, LocalDate date) {
        return customerService.getBuses(fromLoc, toLoc, date);
    }

    public Ticket bookTicket(Optional<Schedule> selectedSchedule, Optional<ScheduledSeat> selectedSeat, User user) {
        return customerService.bookTicket(selectedSchedule, selectedSeat, user);
    }

    public List<Ticket> getTickets() {
        return customerService.getTickets();
    }
}
