package reservation.controller.admin;

import reservation.model.bus.Bus;
import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.seat.Seat;
import reservation.service.admin.Admin;
import reservation.service.admin.AdminService;
import reservation.service.customer.CustomerService;

import java.util.List;

public class AdminController {

    private volatile static AdminController adminController;
    private final Admin adminService;

    private AdminController() {
        adminService = AdminService.getInstance();
    }

    public static AdminController getInstance() {

        if (adminController == null) {
            synchronized (CustomerService.class) {
                if (adminController == null) {
                    adminController = new AdminController();
                }
            }
        }
        return adminController;
    }

    public Bus addBus(String busNumber, boolean isAc, String busType) {
        return adminService.addBus(busNumber, isAc, busType);
    }

    public Seat addSeat(String busNumber, String seatNumber, int seatType) {
        return adminService.addSeat(busNumber, seatNumber, seatType);
    }

    public Schedule addSchedule(String busNumber, Location from, Location to, String date, String departure) {
        return adminService.addSchedule(busNumber, from, to, date, departure);
    }

    public List<Bus> getBuses() {
        return adminService.getBuses();
    }

    public List<Seat> getSeats(String busNumber) {
        return adminService.getSeats(busNumber);
    }

    public List<Schedule> getSchedules(String busNumber) {
        return adminService.getSchedules(busNumber);
    }
}
