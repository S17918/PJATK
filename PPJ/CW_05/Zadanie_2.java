package CW_05;

import java.util.Random;

public class Zadanie_2 {
    public static void main(String[] args){
        Random r = new Random();
        char chr = (char)(r.nextInt(26)+'A');

        System.out.println(chr);

        if(chr >= 'A' && chr <= 'G'){
            System.out.println("Znak A-G");
        }else if(chr >= 'H' && chr <= 'Z'){
            System.out.println("Znak H-Z");
        }else{
            System.out.println("Error");
        }

    }
}