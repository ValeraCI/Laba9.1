package com.company;


import java.util.ArrayList;
import java.util.List;

public class Airport {

    private int numberOfLanes;
    private int numberOfOccupiedLanes = 0;
    private int numberOfAircraft;
    private int numberOfAircraftOnTheGround = 0;

    private List<Plane> planes = new ArrayList();

    public Airport(int numberOfLanes, int numberOfAircraft) {
        this.numberOfLanes = numberOfLanes;
        this.numberOfAircraft = numberOfAircraft;

        for(int i = 0; i < numberOfAircraft; i++){
            planes.add(new Plane());
        }
    }

    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    public int getNumberOfOccupiedLanes() {
        return numberOfOccupiedLanes;
    }

    public synchronized void takePlane(Plane plane){
        numberOfAircraftOnTheGround +=1;
        numberOfOccupiedLanes +=1;
    }

    public synchronized void sendPlane(Plane plane, int number){
        System.out.println("Полоса " + number + " отправила самолёт " + plane);
        plane.setOnTheGround(false);
        numberOfAircraftOnTheGround -=1;
        numberOfOccupiedLanes -=1;
    }

    int i = 0;

    public synchronized Plane getFreePlane(int number){
        while (true){
            if(numberOfAircraft == numberOfAircraftOnTheGround) return null;
            Plane plane = planes.get(i % planes.size());
            if(i > planes.size())i=0;
            else i++;
            if(!plane.isOnTheGround()){
                plane.setOnTheGround(true);
                System.out.println("Полоса " + number + " приняла самолёт " + plane);
                return plane;
            }
        }
    }



}
