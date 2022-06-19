package reservation.service.utils;

import java.util.UUID;

public class UniqueIdGeneratorUtil {

    public static String getId() {
        return (UUID.randomUUID() + "").replaceAll("-", "");
    }

}
