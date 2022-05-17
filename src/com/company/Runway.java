package com.company;

public class Runway extends Thread {
    private Plane plane;
    private final Airport airport;

    public Runway(Airport airport) {
        this.airport = airport;
    }

    public void setPlane(Plane plane){
        this.plane = plane;
    }

    @Override
    public void run() {
        if(plane != null) {
            synchronized(this) {
                plane.setOnTheGround(true);
                System.out.println("Самолёт " + plane);
            }
            try {
                Thread.sleep(5000);
                plane.setOnTheGround(false);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Полоса пуста");
        }

    }
}