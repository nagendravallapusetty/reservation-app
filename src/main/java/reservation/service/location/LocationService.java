package reservation.service.location;
import reservation.model.location.Location;
import reservation.service.data.TestData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationService {

    private volatile static LocationService locationService;

    private LocationService() {

    }

    public static LocationService getInstance() {

        if (locationService == null) {
            synchronized (LocationService.class) {
                if (locationService == null) {
                    locationService = new LocationService();
                }
            }
        }
        return locationService;
    }

    public List<Location> filterLocations(Optional<String> searchTerm) {
        return TestData.getAllLocations().stream().filter((location) ->
                location.getName().toLowerCase().contains(searchTerm.get())).collect(Collectors.toList());
    }
}
