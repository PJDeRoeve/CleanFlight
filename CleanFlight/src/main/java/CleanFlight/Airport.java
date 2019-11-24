package CleanFlight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Wim
 */
public class Airport {
  private int airportid, timezone, coordinatel,coordinateb;
  private String denomination, country, city, code;

    public Airport(int airportid, int timezone, int coordinatel, int coordinateb, String denomination, String country, String city, String code) {
        this.airportid = airportid;
        this.timezone = timezone;
        this.coordinatel = coordinatel;
        this.coordinateb = coordinateb;
        this.denomination = denomination;
        this.country = country;
        this.city = city;
        this.code = code;
    }

    public int getAirportid() {
        return airportid;
    }

    public int getTimezone() {
        return timezone;
    }

    public int getCoordinatel() {
        return coordinatel;
    }

    public int getCoordinateb() {
        return coordinateb;
    }

    public String getDenomination() {
        return denomination;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

}