package reservation.model.bus;

import reservation.model.schedule.Schedule;
import reservation.model.seat.Seat;

import java.util.List;

public interface Bus {

    String getBusId();

    String getBusNumber();

    String getBusType();

    boolean isAc();

    List<Seat> getSeats();

    List<Schedule> getSchedules();

    void addSchedule(Schedule schedule);

    void addSeat(Seat seat);
}
