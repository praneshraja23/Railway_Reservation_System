public class CancleTicket {
    public static void cancleTicket(int id)
    {
        Passenger p=TicketBooking.passengers.get(id);
        TicketBooking.passengers.remove(id);
        TicketBooking.bookedTicketList.remove(id);
        int positionBooked=p.number;

        if(p.alloted.equals("L"))
        {
            TicketBooking.avaliablelowBerth++;
            TicketBooking.lowerBerthPosition.add(positionBooked);
        }
        else if(p.alloted.equals("M"))
        {
            TicketBooking.avaliablemiddleBerth++;
            TicketBooking.middleBerthPosition.add(positionBooked);
        }
        else if(p.alloted.equals("U"))
        {
            TicketBooking.avaliableupperBerth++;
            TicketBooking.upperBerthPosition.add(positionBooked);
        }

        if(TicketBooking.racList.size()>0)
        {
            Passenger racPassenger=TicketBooking.passengers.get(TicketBooking.racList.poll());
            int racPos=racPassenger.number;
            TicketBooking.racPosition.add(racPos);
            TicketBooking.racList.remove(racPassenger.Passenger_id);
            TicketBooking.avaliableRacTicket++;

            if(TicketBooking.waitingList.size()>0)
            {
                Passenger wtPassenger=TicketBooking.passengers.get(TicketBooking.waitingList.poll());
                int wtPos=wtPassenger.number;
                TicketBooking.waitingListPosition.add(wtPos);
                TicketBooking.waitingList.remove(wtPassenger.Passenger_id);

                wtPassenger.number=TicketBooking.racPosition.get(0);
                wtPassenger.alloted="Rac";
                TicketBooking.racPosition.remove(0);
                TicketBooking.racList.add(wtPassenger.Passenger_id);
                
                TicketBooking.avaliableWaitingList++;
                TicketBooking.avaliableRacTicket--;
            }
            Main.booking(racPassenger);
        }
       

    }
}
