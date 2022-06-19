package reservation.service.utils;

import reservation.model.bus.Bus;
import reservation.model.bus.DeluxeBus;
import reservation.model.bus.SuperLuxury;
import reservation.service.admin.exception.InvalidBusTypeException;

public class BusFactory {

    public static Bus getBus(String busType, String busId, String busNumber, boolean isAc) {
        Bus bus = null;
        switch (busType) {
            case "superLuxury":
                bus = new SuperLuxury(busId, busNumber);
                break;

            case "deluxe":
                bus = new DeluxeBus(busId, busNumber);
                break;

            default:
                throw new InvalidBusTypeException("Invalid bus type");

        }
        return bus;
    }
}
