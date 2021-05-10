package CW_04;

import java.util.Scanner;

public class Zadanie_1 {
    public static void main(String[] args){

        boolean tak = true;
        boolean nie = false;
        boolean wynik; 

        System.out.print("Podaj liczbę: ");
        Scanner scan = new Scanner(System.in);
        int wrt = scan.nextInt();

        wynik = (wrt >= 0 ) ? tak : nie; 
        System.out.println("Czy pasuje do zbioru A: "+ wynik);

        wynik = (wrt <= 1 ) ? tak : nie; 
        System.out.println("Czy pasuje do zbioru B: "+ wynik);

        wynik = (wrt >= 0 && wrt <= 1) ? tak : nie; 
        System.out.println("Czy pasuje do zbioru C: "+ wynik);

        scan.close();
    }
}