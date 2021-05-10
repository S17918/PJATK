package MP01;

import java.util.ArrayList;
import java.util.List;

/*
    Piotr Wasilewski
    S17918
*/

public class Obiekt extends ObjectPlus{
    public String objectName;
    public String objectSize;
    public int objectRecord;
    public List<Zawody> zawodyLista = new ArrayList<>();
    public Lokalizacja lokalizacja; 

    public Obiekt(String nazwaObiektu, Lokalizacja lokalizacja, String rozmiarObiektu, int rekordObiektu){
        this.objectName = nazwaObiektu;
        this.lokalizacja = lokalizacja;
        this.objectSize = rozmiarObiektu;
        this.objectRecord = rekordObiektu;
    }

    public Obiekt(String nazwaObiektu, Lokalizacja lokalizacja, String rozmiarObiektu){
        this.objectName = nazwaObiektu;
        this.lokalizacja = lokalizacja;
        this.objectSize = rozmiarObiektu;
    }

    //Kompozycja
    public void addZawody(Zawody zawody) throws Exception{
        if(!zawodyLista.contains(zawody)){
            zawodyLista.add(zawody);
        }
    }
}