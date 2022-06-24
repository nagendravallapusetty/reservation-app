package reservation.service.location;

import reservation.model.location.Location;

import java.util.List;
import java.util.Optional;

public interface LocationApi {

    List<Location> filterLocations(Optional<String> searchTerm);
}
