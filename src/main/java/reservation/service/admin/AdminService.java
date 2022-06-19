package reservation.service.admin;

import reservation.model.bus.Bus;
import reservation.service.admin.exception.BusAlreadyExistsException;
import reservation.service.utils.BusFactory;
import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.seat.Seat;
import reservation.model.seat.status.SeatAvailable;
import reservation.service.admin.exception.BusNotFoundException;
import reservation.service.customer.CustomerService;
import reservation.service.data.TestData;
import reservation.service.utils.UniqueIdGeneratorUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService {

    private volatile static AdminService adminService;

    private AdminService() {

    }

    public static AdminService getInstance() {

        if (adminService == null) {
            synchronized (CustomerService.class) {
                if (adminService == null) {
                    adminService = new AdminService();
                }
            }
        }
        return adminService;
    }

    public Bus addBus(String busNumber, boolean isAc, String busType) {
        Bus bus = BusFactory.getBus(busType, UniqueIdGeneratorUtil.getId(), busNumber, isAc);
        if (TestData.getAllBuses().containsKey(busNumber))
            throw new BusAlreadyExistsException("Bus is already present in our store");


        TestData.getAllBuses().put(busNumber, bus);
        return bus;
    }

    public Seat addSeat(String busNumber, String seatNumber, int seatType) {
        Bus bus = TestData.getAllBuses().get(busNumber);
        if (bus == null)
            throw new BusNotFoundException("Invalid bus number entered");

        Seat seat = new Seat(UniqueIdGeneratorUtil.getId(), seatNumber, seatType == 1 ? Seat.Type.SINGLE : Seat.Type.SLEEPER, bus);
        bus.getSeats().add(seat);
        return seat;
    }

    public Schedule addSchedule(String busNumber, Location from, Location to, String date, String departure) {
        Bus bus = TestData.getAllBuses().get(busNumber);
        if (bus == null)
            throw new BusNotFoundException("Invalid bus number entered");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        Schedule schedule = new Schedule(UniqueIdGeneratorUtil.getId(), localDate, from, to,
                LocalTime.parse(departure, DateTimeFormatter.ISO_LOCAL_TIME), bus);

        List<ScheduledSeat> scheduledSeats = bus.getSeats().stream().map(seat ->
                new ScheduledSeat(seat, new SeatAvailable(), 200)).collect(Collectors.toList());

        schedule.setReservedSeats(scheduledSeats);
        bus.addSchedule(schedule);
        TestData.getAllSchedules().add(schedule);

        return schedule;

    }

    public List<Bus> getBuses() {
        return new ArrayList<>(TestData.getAllBuses().values());
    }

    public List<Seat> getSeats(String busNumber) {
        Bus bus = TestData.getAllBuses().get(busNumber);
        if (bus == null)
            throw new BusNotFoundException("Invalid bus number entered");

        return bus.getSeats();
    }

    public List<Schedule> getSchedules(String busNumber) {
        Bus bus = TestData.getAllBuses().get(busNumber);
        if (bus == null)
            throw new BusNotFoundException("Invalid bus number entered");

        return bus.getSchedules();
    }
}
