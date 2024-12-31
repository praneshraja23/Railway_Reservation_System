import java.util.*;
public class Main {
    public static void booking(Passenger p)
    {   TicketBooking bookTicket=new TicketBooking();
        if(TicketBooking.avaliableWaitingList==0)
        {
            System.out.println("Their is no ticket available");
            return;
        }

        if((p.berthPreference.equals("L") && TicketBooking.avaliablelowBerth>0 )||
           (p.berthPreference.equals("M") && TicketBooking.avaliablemiddleBerth>0)||
           (p.berthPreference.equals("U") && TicketBooking.avaliableupperBerth>0))
        {
            
            if(p.berthPreference.equals("L"))
            {
                System.out.println( "your prefered Lowerberth is given");
                bookTicket.bookTicket(p,(TicketBooking.lowerBerthPosition.get(0)),"L");
                TicketBooking.lowerBerthPosition.remove(0);
                TicketBooking.avaliablelowBerth--;
            }
            else if(p.berthPreference.equals("M"))
            {  
                System.out.println("your prefered middleberth is given");
                bookTicket.bookTicket(p,TicketBooking.middleBerthPosition.get(0), "M");
                TicketBooking.middleBerthPosition.remove(0);
                TicketBooking.avaliablemiddleBerth--;
            }
            else if(p.berthPreference.equals("U"))
            {
                System.out.println("your prefered upperberth is given");
                bookTicket.bookTicket(p,TicketBooking.upperBerthPosition.get(0),"U");
                TicketBooking.upperBerthPosition.remove(0);
                TicketBooking.avaliableupperBerth--;
            }

        }
        else if(TicketBooking.avaliablelowBerth>0 )
        {
            System.out.println("lowerberth is given");
            bookTicket.bookTicket(p, TicketBooking.lowerBerthPosition.get(0),"L");
            TicketBooking.lowerBerthPosition.remove(0);
            TicketBooking.avaliablelowBerth--;
        }
        else if(TicketBooking.avaliablemiddleBerth>0)
        {
           System.out.println("middleberth is given");
           bookTicket.bookTicket(p, TicketBooking.middleBerthPosition.get(0), "M");
           TicketBooking.middleBerthPosition.remove(0);
           TicketBooking.avaliablemiddleBerth--;
        }
        else if(TicketBooking.avaliableupperBerth>0)
        {
            System.out.println("upperBerth is given");
            bookTicket.bookTicket(p, TicketBooking.upperBerthPosition.get(0), "U");
            TicketBooking.upperBerthPosition.remove(0);
            TicketBooking.avaliableupperBerth--;
        }
        else if(TicketBooking.avaliableRacTicket>0)
        {
            System.out.println("Rac available ");
            bookTicket.addToRac(p,TicketBooking.racPosition.get(0),"Rac");
        }
        else if(TicketBooking.avaliableWaitingList>0)
        {
            System.out.println("waitList is available");
            bookTicket.addTowaitingList(p, TicketBooking.waitingListPosition.get(0), "Waiting List");
        }
    }
    public static void cancleTicket(int id){
        if(!TicketBooking.passengers.containsKey(id)){
            System.out.println("id is not available");
        }
        else{
            CancleTicket.cancleTicket(id);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1.book Ticket /n 2.cancel Ticket /n 3.Booked ticket /n 4.Avaliable Ticket /n 5.exit");
            int option=sc.nextInt();
            switch (option) {
                case 1:
                {
                    System.out.println("Enter the name,age,berthpreference");
                    String name=sc.next();
                    int age=sc.nextInt();
                    String berthPreference=(sc.next());
                    berthPreference=berthPreference.toUpperCase();
                    Passenger p=new Passenger(name,age,berthPreference);
                    booking(p);
                    break;
                }  
                case 2:
                {
                    System.out.println("Enter the passenger id you want to cancle");
                    int id=sc.nextInt();
                    cancleTicket(id);
                    break;
                }   
                case 3:
                {   
                    TicketBooking.displayPassenger();
                    break;
                }
                case 4:
                {
                    TicketBooking.availableTicket();
                    break;
                }
                case 5:
                {
                    loop=false;
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println("Exit...");
        sc.close();
    }
}
