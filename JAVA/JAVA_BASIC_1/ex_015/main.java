/* 
Write a Java program to swap two variables.
*/

package JAVA_BASIC_1.ex_015;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Podaj liczbę X: ");
        int x = scan.nextInt();
        System.out.print("Podaj liczbę Y: ");
        int y = scan.nextInt();
        System.out.println("\nPodano liczbę X - "+x+" oraz liczbę Y - "+y);
        
        int temp = 0; 

        temp = x;
        x = y;
        y = temp; 

        System.out.println("\nPo zamianie: \nX - "+x+"\nY - "+y);

    }
}