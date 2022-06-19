package reservation.model.bus;

import reservation.model.schedule.Schedule;
import reservation.model.seat.Seat;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBus implements Bus {

    private final String busId;

    private final String busNumber;

    private boolean isAc;

    private List<Seat> seatList;

    private List<Schedule> schedules;

    public AbstractBus(String busId, String busNumber) {
        this.busId = busId;
        this.busNumber = busNumber;
        seatList = new ArrayList<>();
        schedules = new ArrayList<>();
    }

    public boolean isAc() {
        return isAc;
    }

    public void setAc(boolean ac) {
        isAc = ac;
    }

    public String getBusId() {
        return busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public List<Seat> getSeats() {
        return seatList;
    }

    public abstract String getBusType();

    public String toString() {
        return  busNumber + "  " + getBusType();
    }

    @Override
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void addSeat(Seat seat) {
        this.seatList.add(seat);
    }

}
