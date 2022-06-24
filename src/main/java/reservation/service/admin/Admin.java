package reservation.service.admin;

import reservation.model.bus.Bus;
import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.seat.Seat;

import java.util.List;

public interface Admin {

    Bus addBus(String busNumber, boolean isAc, String busType);

    Seat addSeat(String busNumber, String seatNumber, int seatType);

    Schedule addSchedule(String busNumber, Location from, Location to, String date, String departure);

    List<Bus> getBuses();

    List<Seat> getSeats(String busNumber);

    List<Schedule> getSchedules(String busNumber);
}


