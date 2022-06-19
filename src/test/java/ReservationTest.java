import static org.junit.Assert.assertEquals;
import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.service.data.TestData;
import reservation.view.Reservation;

import java.util.Optional;

public class ReservationTest {

    @org.junit.Test
    public void reserveTicket() throws Exception {
        Schedule schedule = TestData.getAllSchedules().get(0);
        ScheduledSeat scheduledSeat = schedule.getReservedSeats().get(0);
        Reservation reservation = new Reservation(Optional.of(schedule), Optional.of(scheduledSeat), null);
        Thread t1 = new Thread(reservation, "reservation thread 1");
        Thread t2 = new Thread(reservation, "reservation thread 2");
        Thread t3 = new Thread(reservation, "reservation thread 3");
        Thread t4 = new Thread(reservation, "reservation thread 4");
        Thread t5 = new Thread(reservation, "reservation thread 5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        assertEquals("booked", scheduledSeat.getStatus().getValue());
    }

}
