package com.s17918.piwneprzepisy;

public class GetVariables {

    public static String beerName;
    public static long beer_ID;

    public static long getBeerId_Brew(long beer_id){
        beer_ID = beer_id;
        return beer_ID;
    }

    public static String getBeerName_Brew(String beer){
        beerName = beer;
        return beerName;
    }

}
