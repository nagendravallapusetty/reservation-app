package reservation.model.bus;

public class SuperLuxury extends AbstractBus {

    private static final String type = "superLuxury";

    public SuperLuxury(String busId, String busNumber) {
        super(busId, busNumber);
    }

    public String getBusType() {
        return type;
    }
}
