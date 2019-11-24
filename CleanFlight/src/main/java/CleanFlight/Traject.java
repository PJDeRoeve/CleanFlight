package CleanFlight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Wim
 */
public class Traject {
   
    ArrayList<Flight> traject;
    double totalPrice; 
    double totalCO2;
    int totalflightTime;
    int totalwaitingTime; 
   
       int numberOfTransfers;
    int depT, arrT;
    int[] depDate, arrDate;
    
    public Traject(ArrayList<Flight> Traject ){
        traject=new ArrayList<Flight>(Traject.size());
        for(int i =0; i<Traject.size();i++){
            traject.add(Traject.get(i));
        }
        numberOfTransfers=(traject.size()-1);
        totalPrice=this.calcPrice(Traject);
        totalCO2=calcCO2(Traject);
        totalwaitingTime=calcWaitingTime(Traject);
        totalflightTime=calcFlightTime(Traject);
        
        Flight firstflight=Traject.get(0);
        Flight lastflight=Traject.get(Traject.size()-1);
        depT=firstflight.getTimeofAri();
        depDate=firstflight.getDateOfDep();
        arrT=lastflight.getTimeofAri();
        arrDate=lastflight.getDateOfAri();
    }

    public int getDepT() {
        return depT;
    }

    public int getArrT() {
        return arrT;
    }

    public int[] getDepDate() {
        return depDate;
    }

    public int[] getArrDate() {
        return arrDate;
    }
    
    public double calcPrice(ArrayList<Flight> Traject){
        double Price=0;
        int numberOfFlights= Traject.size();
        for(int i=0; i<numberOfFlights;i++){
            Flight test= Traject.get(i);
            
            Price=Price+test.getPrice(); 
        }
        
        return Price;
    }
    
    public double calcCO2(ArrayList<Flight> Traject){
        double CO2=0; 
         int numberOfFlights= Traject.size();
         for(int i=0; i<numberOfFlights;i++){
            Flight test= Traject.get(i);
            
            CO2=CO2+test.getCO2(); /**QUERRY NODIG DIE CO2 GEEFT VAN VLUCHT MET VLUCHTID=id*/;
        }
         return CO2;
    } 
    
     public int calcFlightTime(ArrayList<Flight> Traject){
        int flightT=0; 
         int numberOfFlights= Traject.size();
         for(int i=0; i<numberOfFlights;i++){
            Flight test= Traject.get(i);
            int id=test.getVluchtid();
            int ft=60;/**QUERRY NODIG DIE flighttime GEEFT VAN VLUCHT MET VLUCHTID=id*/
            flightT=flightT+ ft; 
        }
         return(flightT);
    } 
     
     public int calcWaitingTime(ArrayList<Flight> Traject){
         int waitingT=0; 
         Flight first= Traject.get(0);
         Flight last= Traject.get(Traject.size()-1);
         int departure= first.getTimeofDep(); /** Querry get dep first flight*/
         int arrival = last.getTimeofAri(); /** Querry get arival last flight*/
         
         int TimezoneDep=0; /**DUMMY*/
         int TimezoneArr=0; /**DUMMY*/
         
         int arriv= arrival+ TimezoneArr;
         int dep= departure+ TimezoneDep;
         
         if(arriv<dep){
             arriv=arriv+(24*60);
             
         }
        int totalT= arriv-dep; 
        int flightT=this.getTotalflightTime();
        
        int waiting=totalT-flightT;
        
        return(waiting);
         
     }
     
     public String describeTraject(Traject t){
         
     }

    public ArrayList<Flight> getTraject() {
        return traject;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalCO2() {
        return totalCO2;
    }

    public int getTotalflightTime() {
        return totalflightTime;
    }

    public int getTotalwaitingTime() {
        return totalwaitingTime;
    }

    public int getNumberOfTransfers() {
        return numberOfTransfers;
    }
    
    public static void main(String[] args){
        ArrayList<Flight> vluchten = new ArrayList<Flight>(3);
        int[] date = new int[3];
        date[0]=1999;
        date[1]=12;
        date[2]=13;
        Flight a = new Flight(100, 1, 2, 100, 10, 60, 0, 60, date, date);
        Flight b = new Flight(200, 2, 3, 200, 10, 60, 120, 180, date, date);
        Flight c = new Flight(300, 3, 4, 100, 10, 60, 240, 300, date, date);
        vluchten.add(a);
        vluchten.add(b);
        vluchten.add(c);
        System.out.println("Aantal vluchten :"+vluchten.size());
        Traject test = new Traject(vluchten);
        System.out.println("Totale vluchttijd : "+test.calcFlightTime(vluchten));
        System.out.println("Totale wachttijd: "+test.calcWaitingTime(vluchten));
        System.out.println("CO2 score: "+test.calcCO2(vluchten));
        System.out.println("Prijs: "+test.calcPrice(vluchten));
        System.out.println("aantal transfers: "+test.getNumberOfTransfers());
    }
    
}
