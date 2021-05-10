package CW_05;

public class Zadanie_1{
    public static void main(String[] args){
        int wrt = (int) (Math.random() * 10);
        System.out.println(wrt);

        if(wrt >= 6 && wrt <= 10){
            System.out.println("Int z przedziału <6,10>");
        }else if(wrt >= 0 && wrt <=5){
            System.out.println("Int z przedziału <0,5>");
        }else{
            System.out.println("Error");
        }

    }
}