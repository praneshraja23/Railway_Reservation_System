public class Passenger {
    static int id=1;
    String name;
    int age;
    String berthPreference;
    int Passenger_id;
    String alloted;
    int number;
    Passenger(String name,int age,String berthPre){
        this.name=name;
        this.age=age;
        this.berthPreference=berthPre;
        this.Passenger_id=id++;
        alloted="";
        number=-1;
    }

}
