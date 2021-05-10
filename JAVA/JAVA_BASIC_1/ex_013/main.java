/*
 Write a Java program to print the area and perimeter of a rectangle.
*/

package JAVA_BASIC_1.ex_013;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Podaj długość: ");
        double x = scan.nextDouble();

        System.out.print("Podaj wysokość: ");
        double y = scan.nextDouble();

        System.out.println("Pole prostokąta to: "+ x*y);
        System.out.println("Obwód prostokąta to: "+ 2*(x+y));

        if(x==y){
            System.out.println("TAK NA PRAWDE JEST TO KWADRAT :D");
        }

    }
}