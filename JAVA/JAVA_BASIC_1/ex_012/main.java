/*
Write a Java program that takes three numbers as input to calculate and print the average of the numbers.
*/

package JAVA_BASIC_1.ex_012;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj 3 liczby: \n1: ");
        double x = scan.nextDouble();
        System.out.print("2: ");
        double y = scan.nextDouble();
        System.out.print("3: ");
        double z = scan.nextDouble();


        System.out.println("Średnia tych liczb to: "+ (x+y+z)/3);

        
    }
}