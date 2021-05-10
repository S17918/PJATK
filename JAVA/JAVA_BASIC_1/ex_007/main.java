/*
Write a Java program that takes a number as input and prints its multiplication table upto 10
Test Data:
Input a number: 8
Expected Output :
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
...
8 x 10 = 80
*/

package JAVA_BASIC_1.ex_007;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Podaj liczbę: ");
        int x = scan.nextInt();

        for(int i = 1; i<11; i++){
            System.out.println(x +" x "+ i +" = "+ x*i);
        }

    }
}