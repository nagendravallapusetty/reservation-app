package reservation.service.location;

import reservation.model.location.Location;
import reservation.service.data.TestData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationApiService implements LocationApi {

    private volatile static LocationApiService locationService;

    private LocationApiService() {

    }

    public static LocationApiService getInstance() {

        if (locationService == null) {
            synchronized (LocationApiService.class) {
                if (locationService == null) {
                    locationService = new LocationApiService();
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
