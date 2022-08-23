package week5.Day20.Assignments.BusReservationSystem.bus.reservation.client;

import week5.Day20.Assignments.BusReservationSystem.bus.reservation.system.TicketBookingThread;
import week5.Day20.Assignments.BusReservationSystem.bus.reservation.system.TicketCounter;

public class Test {

    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter();
        TicketBookingThread t1 = new TicketBookingThread(ticketCounter,"John",2);
        TicketBookingThread t2 = new TicketBookingThread(ticketCounter,"Martin",2);
        
        t1.start();
        t2.start();
    }
}