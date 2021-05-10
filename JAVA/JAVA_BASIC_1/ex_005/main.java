/*
Write a Java program that takes two numbers as input and display the product of two numbers.
Test Data:
Input first number: 25
Input second number: 5
Expected Output :
25 x 5 = 125
*/

package JAVA_BASIC_1.ex_005;

import java.util.Scanner;

public class main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Jakie liczby mam pomnożyć ?\nPodaj pierwszą liczbę: ");
        int x = scan.nextInt();

        System.out.print("Podaj drugą liczbę: ");
        int y = scan.nextInt();

        System.out.println("Wynik mnożenia "+ x + " * " + y + " to: "+ (x*y));
    }
}