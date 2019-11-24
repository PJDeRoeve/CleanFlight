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
public class Aircrafttype {
   int aircraftTypeId, numberofseats;
   String model, code;

    public Aircrafttype(int aircraftTypeId, int numberofseats, String model, String code) {
        this.aircraftTypeId = aircraftTypeId;
        this.numberofseats = numberofseats;
        this.model = model;
        this.code = code;
    }

    public int getAircraftTypeId() {
        return aircraftTypeId;
    }

    public int getNumberofseats() {
        return numberofseats;
    }

    public String getModel() {
        return model;
    }

    public String getCode() {
        return code;
    }
   
   
   
   
   
   
}
