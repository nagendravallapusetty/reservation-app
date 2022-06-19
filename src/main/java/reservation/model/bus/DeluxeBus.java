package reservation.model.bus;

public class DeluxeBus extends AbstractBus {

    private static final String type = "deluxe";

    public DeluxeBus(String busId, String busNumber) {
        super(busId, busNumber);
    }

    public String getBusType() {
        return type;
    }
}
