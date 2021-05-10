package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public class Gosc extends Osoba{

    public int ticketNumber;
    public String ticketType; //Jednodniowy, Weekendowy, Sezonowy

    public Gosc(String Imie, String Nazwisko, String Plec, String Pesel, int numerBiletu, String typBiletu){  
        super(Imie, Nazwisko, Plec, Pesel);

        this.ticketNumber = numerBiletu;
        this.ticketType = typBiletu;

    }

    @Override
    public int getDochody() {
        // TODO Auto-generated method stub
        return 0;
    }
}