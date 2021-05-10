package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public class Ochrona extends Pracownik_Skoczni{

    public boolean gunPermit;

    public Ochrona(String Imie, String Nazwisko, String Plec, String Pesel, String dataZatrudnienia, int pensja, int premia, boolean pozwolenieBron){
        super(Imie, Nazwisko, Plec, Pesel, dataZatrudnienia, pensja, premia);
        this.gunPermit = pozwolenieBron;
    }

    @Override
    public int getDochody() {
        // TODO Auto-generated method stub
        return 0;
    }

}