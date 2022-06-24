package reservation.model.schedule;

import reservation.model.bus.Bus;
import reservation.model.location.Location;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private String scheduleId;

    private LocalDate date;

    private Location fromLocation;

    private Location toLocation;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private Bus bus;

    private List<ScheduledSeat> reservedSeats;

    private List<ScheduledSeat> cancelledSeats;


    public Schedule(String scheduleId, LocalDate date, Location fromLocation, Location toLocation, LocalTime departureTime, Bus bus) {
        this.scheduleId = scheduleId;
        this.date = date;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.departureTime = departureTime;
        this.bus = bus;
        cancelledSeats = new ArrayList<>();
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public Bus getBus() {
        return bus;
    }

    public List<ScheduledSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ScheduledSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void addReservedSeat(ScheduledSeat scheduledSeat) {
        this.reservedSeats.add(scheduledSeat);
    }

    public void addCancelledSeat(ScheduledSeat scheduledSeat) {
        this.cancelledSeats.add(scheduledSeat);
    }

    public String toString() {
        return bus.getBusNumber() + "  " + date + " " + departureTime + " " + fromLocation.getName() + " " + toLocation.getName();
    }
}
