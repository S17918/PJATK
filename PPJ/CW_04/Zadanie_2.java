package CW_04;

import java.util.Calendar;
import java.util.TimeZone;

public class Zadanie_2{
    public static void main(String[] args){

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int dzien = calendar.get(Calendar.DATE);
        int miesiac = calendar.get(Calendar.MONTH) +1;

        System.out.println(dzien);
        System.out.println(miesiac);
    }
}