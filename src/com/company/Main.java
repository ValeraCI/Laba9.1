package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Airport airport = new Airport();
        List<Plane> plans = new ArrayList();
        plans.add(new Plane("Самолёт 1", 1));
        plans.add(new Plane("Самолёт 2", 1));
        plans.add(new Plane("Самолёт 3", 1));
        plans.add(new Plane("Самолёт 4", 1));
        plans.add(new Plane("Самолёт 5", 1));

        List<Runway> runways = new ArrayList();
        for (int i = 0; i < 7; i++) {
            runways.add(new Runway(airport));
        }
        Plane plane;
        int x = 0;
        while (true) {
            plane = plans.get(x % plans.size());
            if (!plane.isOnTheGround()) {
                runways.get(x % runways.size()).setPlane(plane);
                runways.get(x % runways.size()).run();
                x++;
            }
        }
    }
}
