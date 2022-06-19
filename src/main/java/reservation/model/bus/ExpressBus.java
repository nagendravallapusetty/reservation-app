package reservation.model.bus;

public class ExpressBus extends AbstractBus {

    private static final String type = "express";

    public ExpressBus(String busId, String busNumber) {
        super(busId, busNumber);
    }

    public String getBusType() {
        return type;
    }
}
