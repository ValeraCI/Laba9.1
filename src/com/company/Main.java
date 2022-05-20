package com.company;

public class Main {

    static int greaterThanZero(String text){
        int x;
        do{
            x = Input.inInt(text);
            if(x<=0) System.out.println("Число меньше 1");
        }while (x<=0);
        return x;
    }

    public static void main(String[] args){
        int x = greaterThanZero("Введите количество полос: ");
        int y = greaterThanZero("Введите количество самолётов: ");
        Airport airport = new Airport(x, y);
        for(int i = 0; i < x; i++){
            new Runway(airport, (i+1)).start();
        }

    }
}
