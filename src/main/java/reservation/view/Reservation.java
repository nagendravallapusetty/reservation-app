package reservation.view;

import reservation.controller.customer.CustomerController;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.user.User;

import java.util.Optional;

public class Reservation implements Runnable {

    private final Optional<Schedule> selectedSchedule;
    private final Optional<ScheduledSeat> selectedSeat;
    private final User user;

    public Reservation(Optional<Schedule> selectedSchedule, Optional<ScheduledSeat> selectedSeat, User user) {
        this.selectedSchedule = selectedSchedule;
        this.selectedSeat = selectedSeat;
        this.user = user;
    }

    public void run() {
        CustomerController.getInstance().bookTicket(selectedSchedule, selectedSeat, user);
    }
}
