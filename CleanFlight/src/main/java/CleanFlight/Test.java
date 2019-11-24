package CleanFlight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Wim
 */
public class Test {
    public static void main(String[] args) {
        int dep = 1;
        int ariv = 5;
        int[] dag = new int[3];
        dag[0] = 2019;
        dag[1] = 12;
        dag[2] = 2;
        int numberofp = 1;
        int TimeCurrent = 0;
        int numberofroutes = 0;
        ArrayList<Integer> NotYetVis = new ArrayList<Integer>();
        NotYetVis.add(1);
        NotYetVis.add(5);
        NotYetVis.add(2);
        NotYetVis.add(3);
        NotYetVis.add(4);
        ArrayList<Flight> CurrentRoute = new ArrayList<Flight>();
        HashMap<Integer, ArrayList<Flight>> InitialRouteList = new HashMap<Integer,ArrayList<Flight>>();
       
           Flight[] TestVluchten = new Flight[12];
           TestVluchten[0] = new Flight(1, 1, 2, 1, 20,120, 0,120,2,2 );
           TestVluchten[1] = new Flight(2, 1, 3, 1, 30,60 ,60,120,2,2 );
           TestVluchten[2] = new Flight(3, 3, 4, 1, 40,30 ,150,180,2,2 );
           TestVluchten[3] = new Flight(4, 4, 2, 1, 20,150 ,200,350,2,2 );
           TestVluchten[4] = new Flight(5, 2, 5, 1, 50,150 ,150,300,2,2 );
           TestVluchten[5] = new Flight(6, 4, 5, 1, 30,20 ,240,260,2,2 );
           TestVluchten[6] = new Flight(7, 2, 4, 1, 20,50 ,300,350,2,2 );
           TestVluchten[7] = new Flight(8, 4, 5, 1, 60,20, 360,380,2,2 );
           TestVluchten[8] = new Flight(9, 2, 5, 1, 80,50 ,360,410,2,2 );
           TestVluchten[9] = new Flight(10, 4, 5, 1, 30,30 ,360,390,2,2 );
           TestVluchten[10] = new Flight(11, 4, 3, 1, 10,10 ,300,310,2,2 );
           TestVluchten[11] = new Flight(-1, 4, 3, 1, 10,10 ,300,310,2,2 );
          
           

        
        OptimalSearch Try = new OptimalSearch();
        Try.RecursionRoute(dep, ariv, dag, numberofroutes, TimeCurrent, NotYetVis, CurrentRoute, InitialRouteList);
        
            for (int i=0; i< InitialRouteList.size(); i++) {
                String Route = "";
                ArrayList<Flight> RouteLijst = new ArrayList<Flight>();
                RouteLijst = InitialRouteList.get(i);
                for (int l=0; l< RouteLijst.size(); l++) {
                Route = Route + RouteLijst.get(l).getVluchtid();
            }
                System.out.println(Route);
        } 
        
    }

    public Test() {
    }

}
