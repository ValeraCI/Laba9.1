package com.company;

public class Runway extends Thread {
    private final Airport airport;
    private final int number;
    private volatile Plane plane;

    public Runway(Airport airport, int number) {
        this.airport = airport;
        this.number = number;
    }


    @Override
    public void run() {
        while (true) {
            plane = airport.getFreePlane(number);
            if (plane != null) {
                airport.takePlane(plane);
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                airport.sendPlane(plane, number);
            }
            else {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}