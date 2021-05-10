package MP01;

import java.util.ArrayList;
import java.util.Collection;

/*
    Piotr Wasilewski
    S17918
*/

public class Zawody extends ObjectPlus{
    public String nazwa;
    public String data;
    public String timeStart;
    public String timeEnd;
    public ArrayList<String> results;
    public Zawodnik zawodnik;
    public Obiekt obiekt;

    public Zawody(String nazwa, String data, Obiekt obiekt, String godzinaRozpoczecia, String godzinaZakonczenia){
        this.nazwa = nazwa;
        this.data = data;
        this.timeStart = godzinaRozpoczecia;
        this.timeEnd = godzinaZakonczenia;
    }

    public Zawody(String nazwa, String data, Obiekt obiekt, String godzinaRozpoczecia, String godzinaZakonczenia, ArrayList<String> wyniki){
        this.nazwa = nazwa;
        this.data = data;
        this.timeStart = godzinaRozpoczecia;
        this.timeEnd = godzinaZakonczenia;
        this.results = wyniki; 
    }



    //asocjacja kwalifikowana
    public void addZawody(Zawody zawody) throws Exception{
        if(zawody == null){
            throw new Exception("Error");
        }
        obiekt.addZawody(zawody);
    }

    //Kompozycja
    public Zawody createZawody(String nazwa, String data, Obiekt obiekt, String godzinaRozpoczecia, String godzinaZakonczenia) throws Exception{
        if(obiekt == null){
            throw new Exception("Obiekt does not exsist");
        }

        Zawody zawody = new Zawody(nazwa, data, obiekt, godzinaRozpoczecia, godzinaZakonczenia);
        obiekt.addZawody(zawody);

        return zawody;
    }

    public String toString(){
        return nazwa;
    }





}