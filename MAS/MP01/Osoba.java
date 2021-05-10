package MP01;

/*
    Piotr Wasilewski
    S17918
*/

public abstract class Osoba extends ObjectPlusPlus{

    public String Name;
    public String Surname;
    public String Sex; //Male or Female
    public String Pesel;

    public Osoba(){
        
    }

    public Osoba(String Imie, String Nazwisko, String Plec, String Pesel){
        this.Name = Imie;
        this.Surname = Nazwisko;
        this.Sex = Plec;
        this.Pesel = Pesel;
    }

    //Dziedziczenie klasa abstr / polimorfizm (z klasą trener)
    public abstract int getDochody();

}