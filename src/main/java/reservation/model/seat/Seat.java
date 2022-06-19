package reservation.model.seat;

import reservation.model.bus.Bus;

public class Seat {

    public enum Type {

        SINGLE("single"),
        SLEEPER("sleeper");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    private String seatId;

    private String seatNumber;

    private Type seatType;

    private Bus bus;

    public Seat(String seatId, String seatNumber, Type seatType, Bus bus) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.bus = bus;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Type getSeatType() {
        return seatType;
    }

    public String toString() {
        return bus.getBusNumber() + "  " + seatNumber + "  " + seatType.getValue();
    }

}
