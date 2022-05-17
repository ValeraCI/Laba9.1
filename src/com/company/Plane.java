package com.company;

public class Plane{
    private String title;
    private int capacity;
    private boolean onTheGround = false;


    public Plane(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOnTheGround() {
        return onTheGround;
    }

    public void setOnTheGround(boolean onTheGround) {
        this.onTheGround = onTheGround;
    }

    @Override
    public String toString(){
        return title;
    }
}
