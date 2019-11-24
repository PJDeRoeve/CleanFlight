package CleanFlight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CleanFlight.DateAndTime;
import static CleanFlight.DateAndTime.ComposeDateTime;

/**
 *
 * @author Wim
 */
public class Flight {
private int vluchtid;
private int originid;
private int destinationid;
private double CO2;
private double price;
private int duration;
private int[] dateOfDep = new int[3];
private int [] dateOfAri = new int[3];
private int timeOfDep;
private int timeOfAri;
private int nrOfSeatsAvailable;
private Airport airportOfOrigin;
private Airport airportOfArrival;
private Airline airline;
private Aircrafttype aircraft;

    public Flight(int vluchtid, int originid, int destinationid, double CO2, double price, int duration, int timeOfDep, int timeOfAri, int nrOfSeatsAvailable, Airport airportOfOrigin, Airport airportOfArrival, Airline airline, Aircrafttype aircraft) {
        this.vluchtid = vluchtid;
        this.originid = airportOfOrigin.getAirportid();
        this.destinationid = airportOfArrival.getAirportid();
        this.CO2 = CO2;
        this.price = price;
        this.duration = duration;
        this.timeOfDep = timeOfDep;
        this.timeOfAri = timeOfAri;
        for (int i = 0; i< 3; i++) {
        this.dateOfDep[i] = dateOfDep[i];
        this.dateOfAri[i] = dateOfAri[i];
        }
        this.nrOfSeatsAvailable = nrOfSeatsAvailable;
        this.airportOfOrigin = airportOfOrigin;
        this.airportOfArrival = airportOfArrival;
        this.airline = airline;
        this.aircraft = aircraft;
    }

    public int getVluchtid() {
        return vluchtid;
    }

    public int getOriginid() {
        return originid;
    }

    public int getDestinationid() {
        return destinationid;
    }

    public double getCO2() {
        return CO2;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public int[] getDateOfDep() {
        return dateOfDep;
    }

    public int[] getDateOfAri() {
        return dateOfAri;
    }

    public int getTimeOfDep() {
        return timeOfDep;
    }

    public int getTimeOfAri() {
        return timeOfAri;
    }

    public int getNrOfSeatsAvailable() {
        return nrOfSeatsAvailable;
    }

    public Airport getAirportOfOrigin() {
        return airportOfOrigin;
    }

    public Airport getAirportOfArrival() {
        return airportOfArrival;
    }

    public Airline getAirline() {
        return airline;
    }

    public Aircrafttype getAircraft() {
        return aircraft;
    }

   



    
    public int CapacityLeft(int vluchtid) {
     /** haalt voor een bepaald vluchtnummer, de bijbehorende totaalzitjes op (SQL)
      op dit moment in totaalzitjes een dummy*/
     int totaalzitjes = 120;
     /** haalt voor een bepaald vluchtnummer de som van het aantal geboekte zitjes op
      op dit moment is geboektezitjes een dummy*/
     
     int geboektezitjes = 80;
     
     int vrijezitjes = totaalzitjes - geboektezitjes;
         return vrijezitjes;    
     
    }

    public Flight(int vluchtid) {
        this.vluchtid = vluchtid;
    }
   

    @Override
    public String toString() {
        String output = "Flight{" + "vluchtid=" + vluchtid +  ", CO2=" + CO2 + ", price=" + price + ", duration=" + duration + "Moment of depature ="; 
                output = output + ComposeDateTime(dateOfDep, timeOfDep) + " Moment of arrival= " + ComposeDateTime(dateOfAri, timeOfAri);
                
                output = output + ", nrOfSeatsAvailable=" + nrOfSeatsAvailable + ", airportOfOrigin=" + airportOfOrigin.toString() + ", airportOfArrival=" + airportOfArrival.toString() + ", airline=" + airline.toString() + ", aircraft=" + aircraft.toString() + '}';
                
     return output;
    }
}

    

