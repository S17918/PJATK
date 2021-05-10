package MP01;

import java.util.ArrayList;
import java.util.List;

/*
    Piotr Wasilewski
    S17918
*/

public class Trenuje extends ObjectPlus{
    public String trainingDate;
    public String trainingPlace;
    public Trener trener;
    public List<Zawodnik> zawodnicy = new ArrayList<>();

    public Trenuje(String data, String miejsce){
        this.trainingDate = data;
        this.trainingPlace = miejsce;
    }

    //asocjacja z atrybutem

    public void addZawodnik(Zawodnik zawodnik){
        if(!zawodnicy.contains(zawodnik)){
            zawodnicy.add(zawodnik);
        }
    }
}