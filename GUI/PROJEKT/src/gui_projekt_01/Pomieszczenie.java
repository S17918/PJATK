package gui_projekt_01;

import java.util.Date;

public class Pomieszczenie{
    
    String nazwa;
    private int IdPomieszczenia; 
    private static int numer = 0;
    int PowierzchniaPomieszczenia; 
    boolean Dostepnosc;
    Date data;
    int długosć_najmu;
    
    Pomieszczenie(String nazwa, int PowierzchniaPomieszczenia, boolean Dostepnosc, Date data, int długość_najmu){
        
        this.nazwa = nazwa;
        this.PowierzchniaPomieszczenia = PowierzchniaPomieszczenia;
        this.Dostepnosc = Dostepnosc;
        this.IdPomieszczenia = numer++;
        this.data = data;
        this.długosć_najmu = długość_najmu;
        
        
    }
    
    public static int sprawdz(Pomieszczenie p){
        return p.PowierzchniaPomieszczenia;
    }
    
    public String toString(){
        return nazwa + "\n";
    }
    

}
