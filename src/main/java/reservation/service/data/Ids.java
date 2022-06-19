package reservation.service.data;

import reservation.service.utils.UniqueIdGeneratorUtil;

// Ids which are served from server to client and client to server
public interface Ids {

    String customerId = UniqueIdGeneratorUtil.getId();
    String adminId = UniqueIdGeneratorUtil.getId();

    String superLuxuryId = UniqueIdGeneratorUtil.getId();
    String deluxeId = UniqueIdGeneratorUtil.getId();
    String superLuxuryBusNumber = "TS02AT2256";

    String deluxeNumber = "MH26PQ00003";

    String superLuxurySeatId1 = UniqueIdGeneratorUtil.getId();
    String superLuxurySeatId2 = UniqueIdGeneratorUtil.getId();

    String deluxeSeatId1 = UniqueIdGeneratorUtil.getId();
    String deluxeSeatId2 = UniqueIdGeneratorUtil.getId();

    String superLuxuryHydToPuneScheduleId1 = UniqueIdGeneratorUtil.getId();
    String superLuxuryPunToHydScheduleId2 = UniqueIdGeneratorUtil.getId();
    String deluxeHydToPuneScheduleId1 = UniqueIdGeneratorUtil.getId();
    String deluxePuneToHydScheduleId2 = UniqueIdGeneratorUtil.getId();

    String hydLocationId = UniqueIdGeneratorUtil.getId();
    String puneLocationId = UniqueIdGeneratorUtil.getId();
    String haryanaLocationId = UniqueIdGeneratorUtil.getId();
    String himachalPradeshLocationId = UniqueIdGeneratorUtil.getId();
    String punjabLocationId = UniqueIdGeneratorUtil.getId();
    String puducherryLocationId = UniqueIdGeneratorUtil.getId();

}
