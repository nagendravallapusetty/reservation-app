package reservation.view.person;

import reservation.controller.admin.AdminController;
import reservation.controller.authentication.AuthenticationController;
import reservation.controller.location.LocationController;
import reservation.model.bus.Bus;
import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.seat.Seat;
import reservation.model.user.User;
import reservation.service.data.Ids;
import reservation.view.util.ClientUtil;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Admin implements Person {

    private final AdminController adminController;
    private final AuthenticationController authenticationController;
    private final LocationController locationController;
    private final User user;

    Admin() {
        adminController = AdminController.getInstance();
        authenticationController = AuthenticationController.getInstance();
        locationController = LocationController.getInstance();
        user = getUser();
    }


    @Override
    public User getUser() {
        return authenticationController.login(Ids.adminId);
    }

    @Override
    public void process() {
        Optional<String> logout = Optional.empty();

        do {

            System.out.println(" Welcome admin! what do you want to do ? ");
            System.out.println("1. Register bus");
            System.out.println("2. Add seats to existing bus");
            System.out.println("3. Schedule bus");
            System.out.println("4. Customize seat price for specific schedule");
            System.out.println("5. View buses");
            System.out.println("6. View Seats");
            System.out.println("7. View schedules");
            System.out.println("8. Logout");

            int option = ClientUtil.readInt(8);

            switch (option) {
                case 1:
                    registerBus();
                    break;

                case 2:
                    addSeatsToBus();
                    break;

                case 3:
                    scheduleBus();;
                    break;

                case 4:
                    customizeSeatPriceForSpecificSchedule();
                    break;

                case 5:
                    viewBuses();
                    break;

                case 6:
                    viewSeats();
                    break;

                case 7:
                    viewSchedules();
                    break;

                case 8:
                    System.out.println("Logging out, please wait ..");
                    break;

            }

            if (option == 8)
                break;

            System.out.println("do you want to continue as an admin again (yes/no)");
            logout = ClientUtil.readText();

        } while ("yes".equalsIgnoreCase(logout.get()));


    }

    public void viewBuses() {
        List<Bus> buses = adminController.getBuses();
        if (buses.isEmpty()) {
            System.out.println(" no buses found ");
        }
        else {
            buses.forEach(System.out::println);
        }
    }

    public void viewSeats() {
        try {

            System.out.println(" Please enter bus number ");
            Optional<String> busNumber = ClientUtil.readText();

            List<Seat> seats = adminController.getSeats(busNumber.get());
            if (seats.isEmpty()) {
                System.out.println("no seats found");
            }
            else {
                seats.forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewSchedules() {

        try {

            System.out.println(" Please enter bus number ");
            Optional<String> busNumber = ClientUtil.readText();

            List<Schedule> schedules = adminController.getSchedules(busNumber.get());

            if (schedules.isEmpty()) {
                System.out.println("no schedules found");
            }
            else {
                schedules.forEach(System.out::println);
            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void registerBus() {
        try {
            System.out.println(" Please enter bus number ");
            Optional<String> busNumber = ClientUtil.readText();
            System.out.println(" Is this ac bus ? (true/false) ");
            Scanner scanner = new Scanner(System.in);
            boolean isAc = scanner.nextBoolean();
            System.out.println(" Please select bus type ");
            System.out.println("1. Super luxury");
            System.out.println("2. Deluxe");
            int busType = ClientUtil.readInt(2);
            Bus bus = adminController.addBus(busNumber.get(), isAc, busType == 1 ? "superLuxury" : "deluxe");
            System.out.println("Added successfully \n" + bus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addSeatsToBus() {
        try {

            System.out.println(" Please enter bus number ");
            Optional<String> busNumber = ClientUtil.readText();
            Optional<String> option = Optional.of("yes");

            do {
                System.out.println(" Please enter seat number ");
                Optional<String> seatNumber = ClientUtil.readText();
                System.out.println(" Please select seat type ");
                System.out.println("1. Single");
                System.out.println("2. Sleeper");
                int seatType = ClientUtil.readInt(2);
                Seat seat = adminController.addSeat(busNumber.get(), seatNumber.get(), seatType);
                if (seat == null) {
                    System.out.println("Invalid bus number entered");
                    System.out.println("Do you want to continue by entering valid bus number ? (yes/no)");
                    option = ClientUtil.readText();
                    if ("yes".equalsIgnoreCase(option.get())) {
                        System.out.println(" Please enter valid bus number ");
                        busNumber = ClientUtil.readText();
                    }
                } else {
                    System.out.println("Added successfully ");
                    System.out.println(" Do you to continue to add more seats to this bus ? (yes/no)");
                    option = ClientUtil.readText();
                }
            } while ("yes".equalsIgnoreCase(option.get()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void scheduleBus() {

        try {

            System.out.println(" Please enter bus number ");
            Optional<String> busNumber = ClientUtil.readText();

            System.out.println("From location - please type some word and enter to search");

            List<Location> filteredLocations = ClientUtil.filterLocations(locationController);
            Optional<Location> fromLocation = ClientUtil.read(filteredLocations);

            System.out.println("To location - please type some word and enter to search");
            filteredLocations = ClientUtil.filterLocations(locationController);
            Optional<Location> toLocation = ClientUtil.read(filteredLocations);

            System.out.println("Please enter schedule date (d/MM/yyyy)");
            Optional<String> date = ClientUtil.readText();

            System.out.println("Please enter  departure time");
            Optional<String> departureTime = ClientUtil.readText();

            Schedule schedule = adminController.addSchedule(busNumber.get(), fromLocation.get(), toLocation.get(), date.get(), departureTime.get());
            System.out.println("Added successfully");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void customizeSeatPriceForSpecificSchedule() {
        System.out.println("Work in progress");
    }
}
