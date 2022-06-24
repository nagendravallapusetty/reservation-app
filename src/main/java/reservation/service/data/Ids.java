package reservation.service.data;

import reservation.service.utils.UniqueIdGeneratorUtil;

// Ids which are served from server to client and client to server
public class Ids {

    public static final String customerId = UniqueIdGeneratorUtil.getId();
    public static final String adminId = UniqueIdGeneratorUtil.getId();

    public static final String superLuxuryId = UniqueIdGeneratorUtil.getId();
    public static final String deluxeId = UniqueIdGeneratorUtil.getId();
    public static final String superLuxuryBusNumber = "TS02AT2256";

    public static final String deluxeNumber = "MH26PQ00003";

    public static final String superLuxurySeatId1 = UniqueIdGeneratorUtil.getId();
    public static final String superLuxurySeatId2 = UniqueIdGeneratorUtil.getId();

    public static final String deluxeSeatId1 = UniqueIdGeneratorUtil.getId();
    public static final String deluxeSeatId2 = UniqueIdGeneratorUtil.getId();

    public static final String superLuxuryHydToPuneScheduleId1 = UniqueIdGeneratorUtil.getId();
    public static final String superLuxuryPunToHydScheduleId2 = UniqueIdGeneratorUtil.getId();
    public static final String deluxeHydToPuneScheduleId1 = UniqueIdGeneratorUtil.getId();
    public static final String deluxePuneToHydScheduleId2 = UniqueIdGeneratorUtil.getId();

    public static final String hydLocationId = UniqueIdGeneratorUtil.getId();
    public static final String puneLocationId = UniqueIdGeneratorUtil.getId();
    public static final String haryanaLocationId = UniqueIdGeneratorUtil.getId();
    public static final String himachalPradeshLocationId = UniqueIdGeneratorUtil.getId();
    public static final String punjabLocationId = UniqueIdGeneratorUtil.getId();
    public static final String puducherryLocationId = UniqueIdGeneratorUtil.getId();

}
