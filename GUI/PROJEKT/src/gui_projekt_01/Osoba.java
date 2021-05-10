package gui_projekt_01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Osoba{
    
    String Imie;
    String Nazwisko;
    String Pesel;
    String AdresZamieszkania;
    String DataUrodzenia;
    SimpleDateFormat data_pierwszego_najmu;
    
    
    
    Osoba(String Imie, String Nazwisko, String Pesel, String AdresZamieszkania, String DataUrodzenia, SimpleDateFormat data_pierwszego_najmu){
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.Pesel = Pesel;
        this.AdresZamieszkania = AdresZamieszkania;
        this.DataUrodzenia = DataUrodzenia;
        this.data_pierwszego_najmu = data_pierwszego_najmu;
    }   
    
    public String toString(){
        return this.Imie + " " + this.Nazwisko; 
    }


public static String ShowOsoba(Osoba o) throws NeverRentException{
    return " Imie:                                        " + o.Imie + "\n"+
           " Nazwisko:                               " + o.Nazwisko + "\n"+
           " Pesel:                                      " + o.Pesel + "\n" +
           " Adres Zamieszkania:             " + o.AdresZamieszkania + "\n" +
           " Data Urodzenia:                     " + o.DataUrodzenia;/* + "\n" +
           " Data Pierwszego Najmu:      " + SprawdzCzyWynajm(o.data_pierwszego_najmu);*/
       
}    
    

}
