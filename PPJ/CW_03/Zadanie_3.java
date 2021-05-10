package CW_03;

import java.util.Scanner;

public class Zadanie_3 {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj liczbę: ");
        int wrt = scan.nextInt();

        if(wrt > (-15) && wrt < (-10)){
            if(wrt < (-13)){
                System.out.println("Liczba pasuje do obu zbiorów A i B");
            }else{
                System.out.println("Liczba pasuje tylko do zbioru A");
            }
        }else if(wrt < (-13)){
            System.out.println("Liczba pasuje tylko do zbioru B");
        }else{
            System.out.println("Liczba nie pasuje do żadnego zbioru");
        }
        
        scan.close();
    }
}