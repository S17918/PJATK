package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public class Kibic extends Gosc{

    public int cardNumber;
    public String activationDate;
    public String expireDate;

    public Kibic(String Imie, String Nazwisko, String Plec, String Pesel, int numerBiletu, String typBiletu, int numerKarty, String dataAktywacji, String dataWygasniecia){
        super(Imie, Nazwisko, Plec, Pesel, numerBiletu, typBiletu);

        this.cardNumber = numerKarty;
        this.activationDate = dataAktywacji;
        this.expireDate = dataWygasniecia;

    }
}