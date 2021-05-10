package CW_03;

import java.util.Scanner;

public class Zadanie_2 {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj liczbę: ");
        int wrt = scan.nextInt();

        //Zbiór A
        if(wrt > (-15) && wrt <= (-10)){
            System.out.println("Pasuje do zbioru A");
        }else if(wrt > (-5) && wrt < 0){
            System.out.println("Pasuje do zbioru A");
        }else if(wrt > 5 && wrt < 10){
            System.out.println("Pasuje do zbioru A");
        }else{
            System.out.println("Podana liczba nie mieści się w zbiorze A");
        }

        //Zbiór B
        if(wrt <= -13){
            System.out.println("Pasuje do zbioru B");
        }else if(wrt > (-8) && wrt <= (-3)){
            System.out.println("Pasuje do zbioru B");
        }else{
            System.out.println("Podana liczba nie mieści się w zbiorze B");
        }

        //Zbiór C
        if(wrt >= (-4)){
            System.out.println("Pasuje do zbioru C");
        }else{
            System.out.println("Podana liczba nie mieści się w zbiorze C");
        }

        scan.close();
    }
}