package gui_projekt_01;

public class Przedmiot {
    String nazwa;
    int powierzchnia;
    
    Przedmiot(String nazwa, int powierzchnia){
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
    }
    
    @Override
    public String toString(){
        return this.nazwa;
    }
}
