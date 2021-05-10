/*
Write a Java program to print the area and perimeter of a circle.
Test Data:
Radius = 7.5
Expected Output
Perimeter is = 47.12388980384689
Area is = 176.71458676442586
*/

package JAVA_BASIC_1.ex_011;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj promień: ");
        double r = scan.nextDouble();

        System.out.println("\nObwód okręgu wynosi: "+ 2*Math.PI*r);
        System.out.println("Pole koła wynosi: "+ Math.PI*r*r);
    }
}