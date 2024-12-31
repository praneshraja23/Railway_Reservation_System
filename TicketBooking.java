import java.util.*;

public class TicketBooking {
    
    static int avaliablelowBerth=1;
    static int avaliablemiddleBerth=1;
    static int avaliableupperBerth=1;
    static int avaliableRacTicket=1;
    static int avaliableWaitingList=1;

    static Queue<Integer> racList=new LinkedList<>();
    static Queue<Integer> waitingList=new LinkedList<>();
    static List<Integer> bookedTicketList=new ArrayList<>();

    static List<Integer> lowerBerthPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPosition=new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPosition=new ArrayList<>(Arrays.asList(1));

    static Map<Integer,Passenger> passengers=new HashMap<>();

    public void bookTicket(Passenger p,int seatno,String berthalloted)
    {
        p.number=seatno;
        p.alloted=berthalloted;

        passengers.put(p.Passenger_id,p);
        bookedTicketList.add(p.Passenger_id);

        System.out.print("--------------ticket booked successfully");
    }
    public void addToRac(Passenger p,int racinfo,String allotedRac)
    {
        p.number=racinfo;
        p.alloted=allotedRac;
        
        passengers.put(p.Passenger_id,p);
        racList.add(p.Passenger_id);
        racPosition.remove(0);
        avaliableRacTicket--;
    }

    public void addTowaitingList(Passenger p, int waitingListInfo,String allotedWaitList)
    {
        p.number=waitingListInfo;
        p.alloted=allotedWaitList;
        passengers.put(p.Passenger_id,p);
        waitingList.add(p.Passenger_id);

        waitingListPosition.remove(0);
        avaliableWaitingList--;
    }

    
    public static void displayPassenger(){
        if(bookedTicketList.size()==0){
            System.out.println("No ticket is booked");
            return;
        }
       for(Passenger p:passengers.values()){
        System.out.println("PASSENGER ID " + p.Passenger_id);
        System.out.println(" Name " + p.name );
        System.out.println(" Age " + p.age );
        System.out.println(" Status " + p.number + p.alloted);
        System.out.println("--------------------------");
       }
       return;
    } 
    public static void availableTicket()
    {
        System.out.printf("avaliablelowBerth :%d\n",avaliablelowBerth);
        System.out.printf("avaliablemiddleBerth :%d\n",avaliablemiddleBerth);
        System.out.printf("avaliableupperBerth :%d\n",avaliableupperBerth);
        System.out.printf("avaliableRacTicket :%d\n",avaliableRacTicket);
        System.out.printf("avaliableWaitingList :%d\n",avaliableWaitingList);
        System.out.println("-------------------------------------------------------");
    }
}
