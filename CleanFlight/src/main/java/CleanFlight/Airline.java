/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CleanFlight;

/**
 *
 * @author Wim
 */
public class Airline {
    int airlineid;
    String code, denomination;

    public Airline(int airlineid, String code, String denomination) {
        this.airlineid = airlineid;
        this.code = code;
        this.denomination = denomination;
    }

    public int getAirlineid() {
        return airlineid;
    }

    public String getCode() {
        return code;
    }

    public String getDenomination() {
        return denomination;
    }







}
