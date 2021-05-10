package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public class Obsluga_Skoczni extends Pracownik_Skoczni{

    public String stanowiskoPracy;

    public Obsluga_Skoczni(String Imie, String Nazwisko, String Plec, String Pesel, String dataZatrudnienia, int pensja, int premia, String stanowisko){
        super(Imie, Nazwisko, Plec, Pesel, dataZatrudnienia, pensja, premia);
        this.stanowiskoPracy = stanowisko;
    }

    @Override
    public int getDochody() {
        // TODO Auto-generated method stub
        return 0;
    }

}