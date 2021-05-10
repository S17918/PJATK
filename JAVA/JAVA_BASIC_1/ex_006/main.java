/* 
Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers.
Test Data:
Input first number: 125
Input second number: 24
Expected Output :
125 + 24 = 149
125 - 24 = 101
125 x 24 = 3000
125 / 24 = 5
125 mod 24 = 5
*/

package JAVA_BASIC_1.ex_006;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("\n\nPodaj pierwszą liczbę: ");
        int x = scan.nextInt();

        System.out.print("Podaj drugą liczę: ");
        int y = scan.nextInt();

        System.out.println("\nSuma: "+ (x+y));
        System.out.println("Odejmowanie: "+ (x-y));
        System.out.println("Mnożenie: "+ (x*y));
        System.out.println("Dzielenie: "+ (x/y));
        System.out.println("Podzielność: "+ (x%y)+"\n\n");
        
    }
}