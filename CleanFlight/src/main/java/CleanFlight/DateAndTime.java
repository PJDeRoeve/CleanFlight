package CleanFlight;



/**
 *
 * @author Wim
 */
public class DateAndTime {
/* Formaat moet in YYYYMMDD*/
public static int[] DecomposeDate(String date) /** CHECKED*/
    {
      int datum[] = new int[3];
      datum[0] = Integer.parseInt(date.substring(0,4));
      datum[1] = Integer.parseInt(date.substring(4,6));
      datum[2] = Integer.parseInt(date.substring(6,8));
      
      return datum;
    }

public static String ComposeDateTime(int[] date , int time)/** CHECKED*/
    {
    String datum;
    datum=date[0]+"-"+date[1]+"-"+date[2]+" ";
    
    String tijd;
    int uren = time/60;
    String houre=""+uren;
    int minuten=time%60;
    String min=""+minuten;
    if(uren<10){
       houre="0"+uren;
       
    }
    if(minuten<10){
       min="0"+minuten;
       
    }
    tijd= houre+ ":"+min+":"+"00";
    
    
    return(datum + tijd);
}
        
/* Formaat moet in HHMM*/
public static int DecomposeTime(String time)/** CHECKED*/
    {
      int tijd;
      tijd = Integer.parseInt(time.substring(0,2))*60;
      tijd = tijd+Integer.parseInt(time.substring(3,5));
      return tijd;
    }
public static int DecomposeFlightTime(String time)/** CHECKED
 YYYY-MM-DD HH:MM:SS*/
    {
      int tijd;
      tijd = Integer.parseInt(time.substring(11,13))*60;
      tijd = tijd+Integer.parseInt(time.substring(14,16));
      return tijd;
    }
public static String ComposeTime(int time)/** CHECKED*/
    {
    int uren = time/60;
    String houre=""+uren;
    int minuten=time%60;
    String min=""+minuten;
    if(uren<10){
       houre="0"+uren;
       
    }
    if(minuten<10){
       min="0"+minuten;
       
    }
    String tijd= houre+ ":"+min+":"+"00";
    return(tijd);
}
        
        

public static void main(String[] args){

int tijd=5;
String time=DateAndTime.ComposeTime(tijd);
 System.out.println(time);
}
        
}




