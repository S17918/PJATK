package CW_02;

public class Zadanie_6{
    public static void main(String[] args){
        int x = 69;
        double y = 6.66;

        System.out.println(x);
        System.out.println(y);

        double temp;

        temp = x;
        x = (int)y;
        y = temp;

        System.out.println(x);
        System.out.println(y);
    }
}