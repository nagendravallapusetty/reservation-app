package reservation.controller.location;

import reservation.model.location.Location;
import reservation.service.location.LocationService;

import java.util.List;
import java.util.Optional;

public class LocationController {


    private volatile static LocationController locationController;
    private final LocationService locationService;

    private LocationController() {
        locationService = LocationService.getInstance();
    }

    public static LocationController getInstance() {

        if (locationController == null) {
            synchronized (LocationController.class) {
                if (locationController == null) {
                    locationController = new LocationController();
                }
            }
        }
        return locationController;
    }

    public List<Location> filterLocations(Optional<String> searchTerm) {
        return locationService.filterLocations(searchTerm);
    }

}
