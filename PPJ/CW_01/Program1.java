package CW_01;

import java.util.Scanner;

public class Program1{
    public static void main(String[] args){

        System.out.println("Hello World");

        /*
        
        boolean bool = true;
        int x = 25;
        double y = 5.43;
        char c = 'h';
        
        */

        Scanner scan = new Scanner(System.in);
        int StudentID = scan.nextInt();

        System.out.println("Hello S"+StudentID);

        scan.close();
    }
}