package reservation.service;

import reservation.model.schedule.Schedule;
import reservation.model.schedule.ScheduledSeat;
import reservation.model.ticket.Ticket;
import reservation.model.ticket.status.TicketNew;
import reservation.model.user.User;
import reservation.service.data.TestData;
import reservation.service.utils.UniqueIdGeneratorUtil;

public class TicketHandler {

    private volatile static TicketHandler ticketHandler;

    private TicketHandler() {

    }

    public static TicketHandler getInstance() {

        if (ticketHandler == null) {
            synchronized (TicketHandler.class) {
                if (ticketHandler == null) {
                    ticketHandler = new TicketHandler();
                }
            }
        }
        return ticketHandler;
    }

    public Ticket generate(Schedule selectedSchedule, ScheduledSeat seatSelected, User user) {
        String ticketId = UniqueIdGeneratorUtil.getId();
        Ticket ticket = new Ticket(ticketId, user, seatSelected, selectedSchedule, new TicketNew());

        //send for payment here i.e, set status with pending_payment
        ticket.setTicketStatus(ticket.getTicketStatus().getSuccessState());

        //based on payment state sets next state of ticket i.e, confirmed/failed
        ticket.setTicketStatus(ticket.getTicketStatus().getSuccessState());

        TestData.getAllTickets().put(ticketId, ticket);
        return ticket;
    }

}
