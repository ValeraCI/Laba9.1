package com.company;

import java.util.List;

public class Runway extends Thread {
    private volatile List<Plane> plans;
    private final Airport airport;
    private volatile Plane plane;
    private int i = 0;
    private final int number;

    public Runway(Airport airport, List<Plane> plans, int number) {
        this.airport = airport;
        this.plans = plans;
        this.number = number;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (true){
                    i++;
                    plane = plans.get(i % plans.size());
                    if(!plane.isOnTheGround()){
                        plane.setOnTheGround(true);
                        plans.set(i % plans.size(), plane);
                        break;
                    }
                }
                System.out.println("Самолёт " + plane + " на полосе " + number);
            }
            try {
                Thread.sleep(5000);
                plane.setOnTheGround(false);
                plans.set(i % plans.size(), plane);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}