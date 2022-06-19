package reservation.model.location;

public class Location {

    private String locationId;

    private String name;

    public Location (String locationId, String name) {
        this.locationId = locationId;
        this.name = name;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
