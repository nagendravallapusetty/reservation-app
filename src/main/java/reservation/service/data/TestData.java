package reservation.service.data;

import reservation.model.bus.Bus;
import reservation.model.bus.DeluxeBus;
import reservation.model.bus.SuperLuxury;
import reservation.model.location.Location;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.seat.Seat;
import reservation.model.seat.status.SeatAvailable;
import reservation.model.seat.status.SeatBlocked;
import reservation.model.seat.status.SeatBooked;
import reservation.model.ticket.Ticket;
import reservation.model.user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TestData implements Ids {

    private static List<Schedule> allSchedules;
    private static Map<String, Bus> allBuses;
    private static List<Location> allLocations;
    private static Map<String, User> allUsers;
    private static Map<String, Ticket> allTickets;

    static {

        allUsers = new HashMap<>();
        User user1 = new User(12345, "John");
        user1.setRoles(Arrays.asList("customer"));
        User user2 = new User(67814, "Fred");
        user2.setRoles(Arrays.asList("admin"));
        allUsers.put(customerId, user1);
        allUsers.put(adminId, user2);

        Bus superLuxury = new SuperLuxury(superLuxuryId, superLuxuryBusNumber);
        Bus deluxe = new DeluxeBus(deluxeId, deluxeNumber);
        allBuses = new HashMap<>();
        allBuses.put(superLuxuryBusNumber, superLuxury);
        allBuses.put(deluxeNumber, deluxe);

        //Each bus is having many seats
        Seat superLuxurySeat1 = new Seat(superLuxurySeatId1, "TS-1", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat2 = new Seat(superLuxurySeatId2, "TS-2", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat3 = new Seat(superLuxurySeatId2, "TS-3", Seat.Type.SINGLE, superLuxury);
        Seat superLuxurySeat4 = new Seat(superLuxurySeatId2, "TS-4", Seat.Type.SINGLE, superLuxury);
        Seat superLuxurySeat5 = new Seat(superLuxurySeatId2, "TS-5", Seat.Type.SINGLE, superLuxury);
        Seat superLuxurySeat6 = new Seat(superLuxurySeatId2, "TS-6", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat7 = new Seat(superLuxurySeatId2, "TS-7", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat8 = new Seat(superLuxurySeatId2, "TS-8", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat9 = new Seat(superLuxurySeatId2, "TS-9", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat10 = new Seat(superLuxurySeatId2, "TS-10", Seat.Type.SLEEPER, superLuxury);
        Seat superLuxurySeat11 = new Seat(superLuxurySeatId2, "TS-11", Seat.Type.SLEEPER, superLuxury);

        superLuxury.addSeat(superLuxurySeat1);
        superLuxury.addSeat(superLuxurySeat2);
        superLuxury.addSeat(superLuxurySeat3);
        superLuxury.addSeat(superLuxurySeat4);
        superLuxury.addSeat(superLuxurySeat5);
        superLuxury.addSeat(superLuxurySeat6);
        superLuxury.addSeat(superLuxurySeat7);
        superLuxury.addSeat(superLuxurySeat8);
        superLuxury.addSeat(superLuxurySeat9);
        superLuxury.addSeat(superLuxurySeat10);
        superLuxury.addSeat(superLuxurySeat11);


        Seat deluxeSeat1 = new Seat(deluxeSeatId1, "MH-1", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat2 = new Seat(deluxeSeatId2, "MH-2", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat3 = new Seat(deluxeSeatId2, "MH-3", Seat.Type.SINGLE, deluxe);
        Seat deluxeSeat4 = new Seat(deluxeSeatId2, "MH-4", Seat.Type.SINGLE, deluxe);
        Seat deluxeSeat5 = new Seat(deluxeSeatId2, "MH-5", Seat.Type.SINGLE, deluxe);
        Seat deluxeSeat6 = new Seat(deluxeSeatId2, "MH-6", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat7 = new Seat(deluxeSeatId2, "MH-7", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat8 = new Seat(deluxeSeatId2, "MH-8", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat9 = new Seat(deluxeSeatId2, "MH-9", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat10 = new Seat(deluxeSeatId2, "MH-10", Seat.Type.SLEEPER, deluxe);
        Seat deluxeSeat11 = new Seat(deluxeSeatId2, "MH-11", Seat.Type.SLEEPER, deluxe);

        deluxe.addSeat(deluxeSeat1);
        deluxe.addSeat(deluxeSeat2);
        deluxe.addSeat(deluxeSeat3);
        deluxe.addSeat(deluxeSeat4);
        deluxe.addSeat(deluxeSeat5);
        deluxe.addSeat(deluxeSeat6);
        deluxe.addSeat(deluxeSeat7);
        deluxe.addSeat(deluxeSeat8);
        deluxe.addSeat(deluxeSeat9);
        deluxe.addSeat(deluxeSeat10);
        deluxe.addSeat(deluxeSeat11);

        Location hyderabad = new Location(hydLocationId, "Hyderabad");
        Location pune = new Location(puneLocationId, "Pune");
        allLocations = new ArrayList<>();
        allLocations.add(hyderabad);
        allLocations.add(pune);
        allLocations.add(new Location(haryanaLocationId, "Haryana"));
        allLocations.add(new Location(himachalPradeshLocationId, "Himachal Pradesh"));
        allLocations.add(new Location(punjabLocationId, "Punjab"));
        allLocations.add(new Location(puducherryLocationId, "Puducherry"));


        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();


        //each bus is having many schedules

        Schedule superLuxuryHydToPuneSchedule1 = new Schedule(superLuxuryHydToPuneScheduleId1, localDate.plus(1, ChronoUnit.DAYS),
                hyderabad, pune, localTime.plus(1, ChronoUnit.HOURS), superLuxury);
        //every time we add a schedule record, it populates ScheduledSeat table m2m
        List<ScheduledSeat> superLuxurySchedule1HydToPuneSeats = new ArrayList<>();
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat1, new SeatAvailable(), 2000));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat2, new SeatAvailable(), 2000));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat3, new SeatAvailable(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat4, new SeatAvailable(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat5, new SeatAvailable(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat6, new SeatAvailable(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat7, new SeatAvailable(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat8, new SeatAvailable(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat9, new SeatBlocked(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat10, new SeatBooked(), 1500));
        superLuxurySchedule1HydToPuneSeats.add(new ScheduledSeat(superLuxurySeat11, new SeatBooked(), 1500));
        superLuxuryHydToPuneSchedule1.setReservedSeats(superLuxurySchedule1HydToPuneSeats);
        //

        superLuxury.addSchedule(superLuxuryHydToPuneSchedule1);


        Schedule superLuxuryPuneToHydSchedule2 = new Schedule(superLuxuryPunToHydScheduleId2, localDate.plus(1, ChronoUnit.DAYS),
                pune, hyderabad, localTime.plus(15, ChronoUnit.HOURS), superLuxury);
        //every time we add a schedule record, it populates ScheduledSeat table m2m
        List<ScheduledSeat> superLuxurySchedule2PuneToHydSeats = new ArrayList<>();
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat1, new SeatAvailable(), 5000));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat2, new SeatAvailable(), 5000));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat3, new SeatAvailable(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat4, new SeatAvailable(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat5, new SeatAvailable(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat6, new SeatAvailable(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat7, new SeatAvailable(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat8, new SeatAvailable(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat9, new SeatBlocked(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat10, new SeatBooked(), 2500));
        superLuxurySchedule2PuneToHydSeats.add(new ScheduledSeat(superLuxurySeat11, new SeatBooked(), 2500));
        superLuxuryPuneToHydSchedule2.setReservedSeats(superLuxurySchedule2PuneToHydSeats);
        //

        superLuxury.addSchedule(superLuxuryPuneToHydSchedule2);
        //deluxe
        Schedule deluxeHydToPuneSchedule1 = new Schedule(deluxeHydToPuneScheduleId1, localDate.plus(1, ChronoUnit.DAYS),
                hyderabad, pune, localTime.plus(5, ChronoUnit.HOURS), deluxe);
        //every time we add a schedule record, it populates ScheduledSeat table m2m
        List<ScheduledSeat> deluxeSchedule1HydToPuneSeats = new ArrayList<>();
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat1, new SeatAvailable(), 1500));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat2, new SeatAvailable(), 1500));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat3, new SeatAvailable(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat4, new SeatAvailable(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat5, new SeatAvailable(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat6, new SeatAvailable(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat7, new SeatAvailable(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat8, new SeatAvailable(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat9, new SeatBlocked(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat10, new SeatBooked(), 1100));
        deluxeSchedule1HydToPuneSeats.add(new ScheduledSeat(deluxeSeat11, new SeatBooked(), 1100));
        deluxeHydToPuneSchedule1.setReservedSeats(deluxeSchedule1HydToPuneSeats);
        //

        deluxe.addSchedule(deluxeHydToPuneSchedule1);

        Schedule deluxePuneToHydSchedule2 = new Schedule(deluxePuneToHydScheduleId2, localDate.plus(1, ChronoUnit.DAYS),
                pune, hyderabad, localTime.plus(20, ChronoUnit.HOURS), deluxe);
        //every time we add a schedule record, it populates ScheduledSeat table m2m
        List<ScheduledSeat> deluxeSchedule2PuneToHydSeats = new ArrayList<>();
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat1, new SeatAvailable(), 3800));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat2, new SeatAvailable(), 3800));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat3, new SeatAvailable(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat4, new SeatAvailable(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat5, new SeatAvailable(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat6, new SeatAvailable(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat7, new SeatAvailable(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat8, new SeatAvailable(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat9, new SeatBlocked(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat10, new SeatBooked(), 2600));
        deluxeSchedule2PuneToHydSeats.add(new ScheduledSeat(deluxeSeat11, new SeatBooked(), 2600));
        deluxePuneToHydSchedule2.setReservedSeats(deluxeSchedule2PuneToHydSeats);
        //

        deluxe.addSchedule(deluxePuneToHydSchedule2);

        allSchedules = new ArrayList<>();
        allSchedules.add(superLuxuryHydToPuneSchedule1);
        allSchedules.add(superLuxuryPuneToHydSchedule2);
        allSchedules.add(deluxeHydToPuneSchedule1);
        allSchedules.add(deluxePuneToHydSchedule2);


        allTickets = new HashMap<>();
    }

    public static List<Schedule> getAllSchedules() {
        return allSchedules;
    }

    public static List<Location> getAllLocations() {
        return allLocations;
    }

    public static Map<String, Bus> getAllBuses() {
        return allBuses;
    }

    public static Map<String, User> getAllUsers() {
        return allUsers;
    }

    public static Map<String, Ticket> getAllTickets() {
        return allTickets;
    }
}
