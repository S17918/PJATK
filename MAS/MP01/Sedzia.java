package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public class Sedzia extends Osoba{

    String originCountry;

    public Sedzia(String Imie, String Nazwisko, String Plec, String Pesel, String krajPochodzenia){
        super(Imie, Nazwisko, Plec, Pesel);
        this.originCountry = krajPochodzenia;

    }public Sedzia(String krajPochodzenia){
        this.originCountry = krajPochodzenia;
    }


    @Override
    public int getDochody() {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getCountry(){
        return originCountry;
    }
}