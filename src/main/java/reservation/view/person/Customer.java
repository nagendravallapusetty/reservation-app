package reservation.view.person;

import reservation.controller.authentication.AuthenticationController;
import reservation.controller.customer.CustomerController;
import reservation.controller.location.LocationController;
import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.ticket.Ticket;
import reservation.model.user.User;
import reservation.service.data.Ids;
import reservation.view.util.ClientUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Customer implements Person {

    private final CustomerController customerController;
    private final AuthenticationController authenticationController;
    private final LocationController locationController;
    private final User user;

    Customer() {
        customerController = CustomerController.getInstance();
        authenticationController = AuthenticationController.getInstance();
        locationController = LocationController.getInstance();
        user = getUser();
    }

    @Override
    public User getUser() {
        return authenticationController.login(Ids.customerId);
    }

    @Override
    public void process() {
        Optional<String> logout = Optional.empty();
        System.out.println(" Welcome customer! ");
        do {
            System.out.println(" Please select in the following options ");
            System.out.println("1. Book ticket");
            System.out.println("2. Cancel ticket");
            System.out.println("3. Track ticket status");
            System.out.println("4. View all tickets");
            System.out.println("5. Logout");
            int option = ClientUtil.readInt(5);
            switch (option) {
                case 1:
                    book();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    trackTicket();
                    break;
                case 4:
                    viewTickets();
                    break;
                case 5:
                    System.out.println("Logging out, please wait ..");
            }
            if (option == 5)
                break;

            System.out.println("do you want to continue as a customer again (yes/no)");
            logout = ClientUtil.readText();
        } while ("yes".equalsIgnoreCase(logout.get()));

    }




    private void book() {
        System.out.println("**We are providing service between hyderabad and pune**");
        Optional<String> option = Optional.of("yes");
        List<ScheduledSeat> scheduledSeats = new ArrayList<>();
        List<ScheduledSeat> availableSeats = new ArrayList<>();
        Optional<Schedule> selectedSchedule = Optional.empty();
        do {
            List<Schedule> schedules = new ArrayList<>();
            do {
                System.out.println("From location - please type some word and enter to search");

                List<Location> filteredLocations = ClientUtil.filterLocations(locationController);
                Optional<Location> fromLocation = ClientUtil.read(filteredLocations);

                System.out.println("To location - please type some word and enter to search");
                filteredLocations = ClientUtil.filterLocations(locationController);
                Optional<Location> toLocation = ClientUtil.read(filteredLocations);

                schedules = getBuses(fromLocation, toLocation);

                if (schedules.size() == 0) {
                    System.out.println(" No schedules found, do you want to search again ? (yes/no)");
                    option = ClientUtil.readText();
                }
            } while (schedules.size() == 0 && "yes".equalsIgnoreCase(option.get()));

            if (!"yes".equalsIgnoreCase(option.get()))
                break;

            System.out.println("Please select any schedule like 1, 2, 3 ..etc");
            selectedSchedule = ClientUtil.read(schedules);
            scheduledSeats = getScheduledSeats(selectedSchedule);

            availableSeats = scheduledSeats.stream().filter(
                    (scheduledSeat -> scheduledSeat.getStatus().getValue().equalsIgnoreCase("available"))).collect(Collectors.toList());

            if (availableSeats.size() == 0) {
                ClientUtil.print(scheduledSeats);
                System.out.println(" No seats found, do you want to search again ? (yes/no)");
                option = ClientUtil.readText();
            }
        } while (availableSeats.size() == 0 && "yes".equalsIgnoreCase(option.get()));

        if ("yes".equalsIgnoreCase(option.get())) {
            System.out.println("Please select any seat like 1, 2, 3 .. etc");
            Optional<ScheduledSeat> selectedSeat = ClientUtil.read(scheduledSeats);

            //reserve(null, selectedSeat);
            try {
                Ticket ticket = customerController.bookTicket(selectedSchedule, selectedSeat, user);
                System.out.println(" ** Reservation successful ** ");
                System.out.println(ticket);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

            System.out.println(" ************************************* ");
        }
    }



    private void cancelTicket() {
        try {
            System.out.println(" Please enter ticket number ");
            Optional<String> ticketNumber = ClientUtil.readText();
            Ticket ticket = customerController.cancelTicket(ticketNumber.get());
            System.out.println("************ Ticket is cancelled *********** ");
            System.out.println(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void trackTicket() {
        try {
            System.out.println(" Please enter ticket number ");
            Optional<String> ticketNumber = ClientUtil.readText();
            Ticket ticket = customerController.trackTicket(ticketNumber.get());
            System.out.println("************ Ticket details are *********** ");
            System.out.println(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Schedule> getBuses(Optional<Location> fromLocation, Optional<Location> toLocation) {
        return customerController.getBuses(fromLocation, toLocation, LocalDate.now());
    }

    private List<ScheduledSeat> getScheduledSeats(Optional<Schedule> schedule) {
        return customerController.getScheduledSeats(schedule);
    }

    private void viewTickets() {
        List<Ticket> tickets = customerController.getTickets();
        if (tickets.isEmpty()) {
            System.out.println("no tickets found");
        }
        else {
            tickets.forEach(System.out::println);
        }
    }

}
