package CleanFlight;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wim
 */

public class OptimalSearch {
    
    public OptimalSearch() {
    }
    
    
    public static boolean DoesAirportExist(int id) throws AirportDoesNotExistException {
       /** Query die gaat kijken of de airport in database zit (Exists) 
        * en die 
        ZitErin is een dummy
        AirportName is een dummy, */
       boolean ZitErin = true;
    
       if (ZitErin != true)
           throw new AirportDoesNotExistException(id);
       return ZitErin;
       
    }
    
  
    

    
    
 
    
    /** Deze methode initialiseert ons optimalisatie algoritme
     * We kijken of de airports opgegeven door de gebruiker echt bestaan, en maken de nodige lijsten en hashmap aan nodig voor het recursief algortime
     * We roepen het recursief algoritme op.
     * Methode kan een lege hashmap teruggeven (als er geen verbinding is tussen de luchthavens)
     *
     * */
   
    public static HashMap<Integer, ArrayList <Flight>> RouteLister(int Depar, int Ariv, int[] datestr, int NumOfPassengers, int TimeNow) {
      
     
        
        HashMap<Integer, ArrayList<Flight> > RouteList = new HashMap<Integer, ArrayList<Flight> >();
        ArrayList<Flight> CurrentRoute = new ArrayList<Flight>();
        ArrayList<Integer> NotVisitedYet = new ArrayList<Integer>();
        DateAndTime Timeswitch = new DateAndTime();
        int[] date = new int[3];
        for (int i=0; i<3; i++) {
            date[i] = datestr[i];
           
        }
        
        
       
      
        /** SQLcode die alle airports gaat ophalen, buiten de dep en ariv airports en gaat opslaan in NotVisitedYet
         * vanaf index 2 , want index 0 staat gereserveerd voor Dep en 1 voor arival
         * en , onderstaande code is een Dummy
         */
       NotVisitedYet.add(Depar);
       NotVisitedYet.add(Ariv);
        RecursionRoute(Depar, Ariv, date, NumOfPassengers,TimeNow,NotVisitedYet, CurrentRoute, RouteList);
            
            
           
       
            
        return RouteList;
    } 
    /** Gaat recursief elke route in de HashMap plaatsen (verschillende Vluchten)
     Eerst laden we alle luchthavens in een arraylijst en vertrekkende vanuit de departure airport beginnen we met routes zoeken.
     Routes met meer dan 5 transfers worden direct afgebroken en niet verder onderzocht.
     Deze methode geeft een hashmap van mogelijke routes op met bijbehorende vluchten, rekening houdend met de tijd bij aankomst na elke vlucht
     */ 
    public static void RecursionRoute(int dep, int ariv, int[] date, int NumOfPassengers, int TimeCurrent, ArrayList<Integer> NotYetVis,
            ArrayList<Flight> CurrentRoute, HashMap<Integer, ArrayList<Flight> > RouteList ) {
       
        int TheTime = TimeCurrent;
         ArrayList<Integer> NotVis = new ArrayList<Integer>(NotYetVis);
           ArrayList<Flight> CopyRoute = new ArrayList<Flight>(CurrentRoute);
           NotVis.remove(NotVis.indexOf(dep));
        
           
        for(int i=0; i < NotVis.size() && (CopyRoute.size() < 6); i++) {
       
        

           
           String Dep = Integer.toString(dep);
           String Ari = Integer.toString(NotVis.get(i));
           Flight PossibleFlight = new Flight(1);
  
            
          PossibleFlight = SoonestFlight(dep, NotVis.get(i), date, NumOfPassengers, TimeCurrent);
           
            
           if (PossibleFlight.getVluchtid() > -1 ) {
                CopyRoute.add(PossibleFlight);
                if (PossibleFlight.getTimeOfAri() < TheTime) {
                  date[2] ++;
                }
                TheTime = PossibleFlight.getTimeOfAri();
                
                
             if (PossibleFlight.getDestinationid() == ariv) {
                 ArrayList<Flight> AddRoute = new ArrayList<Flight>(CopyRoute);
                 RouteList.put(RouteList.size(), AddRoute);
                 CopyRoute.remove((CopyRoute.size()-1));
                 
                  
             }
            
             else{ 
              RecursionRoute(PossibleFlight.getDestinationid(), ariv, date, NumOfPassengers, TheTime,  NotVis, CopyRoute
                    ,RouteList );
             CopyRoute.remove((CopyRoute.size()-1));
            }
                      
                      
             
        }
    }
    
                
    }
    
    

public static Flight SoonestFlight(int origin_id, int destination_id, int[] date, int NumOfPassengers, int TimeCurrent) {
 /** SQL code die kijkt of er op deze datum tussen 2 bestemmingen vluchten zijn
  * en de vroegste vluchtinformartie gaat ophalen en deze in de variabele SnelsteVlucht gaat steken
  Ga met een exists functie eerst na of er wel zo een vlucht bestaat -> opslaan in AvailableFlightExists
  * Als die er niet is initialiseren we deze met FlightId = -1
  * Alle parameters die net hieronder staan zijn dummy's
 */

int vluchtid = 1;
int originid = 1;
int destinationid = 1;
double CO2 = 1.5;
double price = 120;
int timeofdep = 60;
int timeofari = 180;
int[] dateofdep = new int[3];
int[] dateofari = new int[3];

int duration = 120;
int capacity = 188;

        
 
 
 boolean AvailableFlightExists = true;
 Flight SnelsteVlucht;
 if (AvailableFlightExists)  {
        
}
 
 else {
     SnelsteVlucht = new Flight(-1);
 }
 
return SnelsteVlucht;
     
 
}
}