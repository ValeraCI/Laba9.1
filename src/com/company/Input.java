package com.company;

import java.util.Scanner;

public class Input {
    static int inInt(String text){
        System.out.print(text);
        while(true){
            try{
                return new Scanner(System.in).nextInt();
            }catch(Exception e){
                System.out.println("Введите целое число");
            }
        }
    }
}
