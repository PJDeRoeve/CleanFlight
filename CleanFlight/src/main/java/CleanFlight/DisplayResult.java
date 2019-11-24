package CleanFlight;



import static CleanFlight.OptimalSearch.RouteLister;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Julian
 */
public class DisplayResult {
  
    public String[] DisplayResults(String dep, String arriv, String date,String time, int nrOfPass, String sort){
        /** Volgende gedeelte zijn dummy waarden           
        
        int[] date = new int[3];
                    date[0]=1999;
                    date[1]=12;
                    date[2]=13;
                    Flight a = new Flight(100, 1, 2, 100, 30, 60, 0, 60, date, date);
                    Flight b = new Flight(200, 2, 3, 100, 30, 60, 120, 180, date, date);
                    Flight c = new Flight(300, 3, 4, 100, 30, 60, 240, 300, date, date);
                    Flight d = new Flight(400, 1, 5, 200, 10, 80, 0, 80, date, date);
                    Flight e = new Flight(500, 5, 6, 200, 10, 80, 120, 200, date, date);
                    Flight f = new Flight(600, 6, 4, 200, 10, 80, 280, 360, date, date);
                    Flight h = new Flight(700, 1, 7, 300, 20, 70, 0, 70, date, date);
                    Flight i = new Flight(800, 7, 8, 300, 20, 70, 140, 210, date, date);
                    Flight j = new Flight(900, 8, 4, 300, 20, 70, 280, 350, date, date);
                    ArrayList<Flight> ac = new ArrayList<Flight>(3);
                    ArrayList<Flight> df = new ArrayList<Flight>(3);
                    ArrayList<Flight> hj = new ArrayList<Flight>(3);
                    ac.add(a);
                    ac.add(b);
                    ac.add(c);
                    df.add(d);
                    df.add(e);
                    df.add(f);
                    hj.add(h);
                    hj.add(i);
                    hj.add(j);
                    * test.put(0, ac);
                    test.put(1, df);
                    test.put(2, hj);
                    HashMap<Integer, ArrayList<Flight>> test= new HashMap<Integer, ArrayList<Flight>>(3);/**PJ ZEN HM*/ 
        
        String depcode = dep.substring((dep.length()-1),(dep.length()-1));
        String arrivcode = arriv.substring((dep.length()-1),(dep.length()-1));
        
    
        /** SQL code die voor de input van Jord zijn GUI, de juiste airport ID voor de depcode (bv BRU) en arrivcode (bv BCN) locatie gaat ophalen en ze in onderstaande variabelen gaat steken
         onderstaande block zijn dummy's*/
       
        int originid = 1;
        int destinationid = 5;
        
        DateAndTime converter = new DateAndTime();
        int[] datum= new int[3];
        datum = DateAndTime.DecomposeDate(date);
        int startTime = DateAndTime.DecomposeTime(time);
        HashMap<Integer, ArrayList<Flight>> test= new HashMap<Integer, ArrayList<Flight>>(RouteLister(originid, destinationid, datum, nrOfPass, startTime));   
        int size= test.size();
        String[] displayresult = new String[size];
        ArrayList<Traject> trajecten= new ArrayList<Traject>(size);
        for(int n=0; n<size; n++){
            ArrayList<Flight> flights=test.get(n);
            Traject traject = new Traject(flights);

            trajecten.add(traject);
           
        }
        
        switch(sort){
            case "LowestPrice" : trajecten=SortPrice(trajecten);
                                 break;
            case "LowestCO2" : trajecten=SortCO2(trajecten);
                                 break;
            case "Fastest" : trajecten=SortTime(trajecten);
                                 break;                     
        }
        for(int n=0; n<size; n++){
             displayresult[n]=DisplayResult.DisplayTraject(trajecten.get(n));
        }
       
        
        return(displayresult);
    }
    
    public static String DisplayTraject(Traject traject){
        String display;
        double price=traject.getTotalPrice();
        double CO2=traject.getTotalCO2();
        int Ttime=traject.getTotalflightTime();
        int Wtime=traject.getTotalwaitingTime();
        String TT=DateAndTime.ComposeTime(Ttime);
        String WT=DateAndTime.ComposeTime(Wtime);
        int not=traject.getNumberOfTransfers();
        String arrDT=DateAndTime.ComposeDateTime(traject.arrDate, traject.getArrT());
        String depDT=DateAndTime.ComposeDateTime(traject.depDate, traject.getDepT());
        display="Price: "+ price+ " euro VluchtTijd: " + TT +" Wachttijd: "+ WT + " Departure Date and Time: " +depDT +" Arrival Date and Time: " +arrDT +" CO2-score: "+ CO2;
        if(not==0){
           display=display + "Directe vlucht" ;
        }
        else{
            display=display+" aantal transfers: "+not;
        }
        
        return(display);
        
    }
    
    public static ArrayList<Traject> SortPrice(ArrayList<Traject> T){
         ArrayList<Traject> Sorted = new ArrayList<Traject>(T.size());
        Sorted.add(T.get(0));
        
        for(int i=1; i<T.size(); i++ ){
            int j=0;
            boolean GreaterThan=true;
        while(GreaterThan){
            if(j>Sorted.size()-1){
                Sorted.add(j, T.get(i));
                GreaterThan=false;
            }
            else if(T.get(i).getTotalPrice()>Sorted.get(j).getTotalPrice()){
                j++;
            }
            else{
                Sorted.add(j, T.get(i));
                GreaterThan=false;
            }
        }
        }
        return(Sorted);
    }
    
    public static ArrayList<Traject> SortCO2(ArrayList<Traject> T){
        ArrayList<Traject> Sorted = new ArrayList<Traject>(T.size());
        Sorted.add(T.get(0));
        
        for(int i=1; i<T.size(); i++ ){
            int j=0;
            boolean GreaterThan=true;
        while(GreaterThan){
            if(j>Sorted.size()-1){
                Sorted.add(j, T.get(i));
                GreaterThan=false;
            }
            else if(T.get(i).getTotalCO2()>Sorted.get(j).getTotalCO2()){
                j++;
            }
            else{
                Sorted.add(j, T.get(i));
                GreaterThan=false;
            }
        }
        }
        return(Sorted);
    }
    
    public static ArrayList<Traject> SortTime(ArrayList<Traject> T){
        ArrayList<Traject> Sorted = new ArrayList<Traject>(T.size());
        Sorted.add(T.get(0));
        
        for(int i=1; i<T.size(); i++ ){
            int j=0;
            boolean GreaterThan=true;
        while(GreaterThan){
            if(j>Sorted.size()-1){
                Sorted.add(j, T.get(i));
                GreaterThan=false;
            }
            else if(T.get(i).getTotalflightTime()>Sorted.get(j).getTotalflightTime()){
                j++;
            }
            else{
                Sorted.add(j, T.get(i));
                GreaterThan=false;
            }
        }
        }
        return(Sorted);
    }
    
    public static void main(String[] args){
        DisplayResult test = new DisplayResult(); 
        String[] ranking1= new String[3];
        String[] ranking2= new String[3];
        String[] ranking3= new String[3];
        
        ranking1=test.DisplayResults(" ", " ", " ", " ", 0, "LowestPrice");
        ranking2=test.DisplayResults(" ", " ", " ", " ", 0, "LowestCO2");
        ranking3=test.DisplayResults(" ", " ", " ", " ", 0, "Fastest");
        System.out.println(ranking1[0]);
        System.out.println(ranking1[1]);
        System.out.println(ranking1[2]);
    }
}