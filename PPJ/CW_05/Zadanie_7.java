package CW_05;

import java.util.Scanner;

public class Zadanie_7 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Podaj szerokość: ");
        int x = scan.nextInt();

        System.out.print("Podaj wysokość: ");
        int y = scan.nextInt();

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(i==0 || i==y-1){
                    System.out.print("*");
                }else if(j==0 || j==x-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scan.close();
    }
}