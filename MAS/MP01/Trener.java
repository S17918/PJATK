package MP01;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/*
    Piotr Wasilewski
    S17918
*/

public class Trener extends Osoba{

    public String hireDate;
    public int salary;
    public List<Zawodnik> zawodnicy = new ArrayList<>(); //implementacja asocjacji "*"
    public Trenuje trening;
    private static String roleSedzia = "specjalizacjaSedzia";

    String Imie;
    String Nazwisko;

    public Trener(String Imie, String Nazwisko, String Plec, String Pesel, String dataZatrudnienia, int pensja){
        super(Imie, Nazwisko, Plec, Pesel);

        this.hireDate = dataZatrudnienia;
        this.salary = pensja;
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;

    }

    public Trener(String Imie, String Nazwisko, String Plec, String Pesel, String dataZatrudnienia, int pensja, Zawodnik zawodnik){
        super(Imie, Nazwisko, Plec, Pesel);

        this.hireDate = dataZatrudnienia;
        this.salary = pensja;
        this.zawodnicy.add(zawodnik);
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;

    }


    public Trener(String Imie, String Nazwisko, String Plec, String Pesel, String dataZatrudnienia, int pensja, String country){
        super(Imie, Nazwisko, Plec, Pesel);

        this.hireDate = dataZatrudnienia;
        this.salary = pensja;
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;

        addSedzia(country);
    }

    public void addSedzia(String country){
        Sedzia sedzia = new Sedzia(country);
        this.addLink(roleSedzia, roleNameGeneralization ,sedzia);
    }

    public boolean hasCountry() throws Exception{
        try {
            ObjectPlusPlus[] obj = this.getLinks(roleSedzia);
            return(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Obiekt nie jest sędzią");
        }
        return false;
    }

    public String toString(){
        return Imie + " " + Nazwisko;
    }


    @Override
    public int getDochody() {
        return getPensja();
    }

    public int getPensja(){
        return salary;
    }
}