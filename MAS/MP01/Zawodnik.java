package MP01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*
    Piotr Wasilewski
    S17918
*/

public class Zawodnik extends Osoba implements Serializable{

    public int playerNumber;
    public int score;
    public int rankingPosition;
    public int experience;
    public int personalRecord;
    public Trener trener; //implementacja asocjacji "1"
    public Trenuje trening;
    
    private static List<Zawodnik> extent = new ArrayList<>();
    private Map<String, Zawody> zawodyQuali = new TreeMap<>();


    public Zawodnik(){
        addPlayer(this);
    }

    public Zawodnik(String Imie, String Nazwisko, String Plec, String Pesel, int numerStartowy, int wynik, int pozycjaWRankingu, int doswiadczenie, int rekordOsobisty){
        super(Imie, Nazwisko, Plec, Pesel);

        this.playerNumber = numerStartowy;
        this.score = wynik;
        this.rankingPosition = pozycjaWRankingu;
        this.experience = doswiadczenie;
        this.personalRecord = rekordOsobisty;

        addPlayer(this);
    }

    public Zawodnik(String Imie, String Nazwisko, String Plec, String Pesel, int numerStartowy, int wynik, int pozycjaWRankingu, int doswiadczenie, int rekordOsobisty, Trener trener){
        super(Imie, Nazwisko, Plec, Pesel);

        this.playerNumber = numerStartowy;
        this.score = wynik;
        this.rankingPosition = pozycjaWRankingu;
        this.experience = doswiadczenie;
        this.personalRecord = rekordOsobisty;
        this.trener = trener;

        addPlayer(this);
    }

    //Asocjacja kwalifikowana
    public void addZawodyQuali(Zawody zawody) throws Exception{
        if(!zawodyQuali.containsKey(zawody.nazwa)){
            zawodyQuali.put(zawody.nazwa, zawody);
            zawody.addZawody(zawody);
        }
    }

    public Zawody findZawodyQuali(String nazwa) throws Exception{
        if(!zawodyQuali.containsKey(nazwa)){
            throw new Exception("Nie znaleziono zawodów" + nazwa);
        }
        return zawodyQuali.get(nazwa);
    }
    //Koniec
    
    public int getPosition(){
        return rankingPosition;
    }



    public static void addPlayer(Zawodnik player){
        extent.add(player);
    }



    public static void removePlayer(Zawodnik player){
        extent.remove(player);
    }



    public static void showPlayers() throws Exception {
        ObjectPlus.showExtent(Zawodnik.class);
    }

    public String getName(){
        return Name + " " + Surname;
    }

    public String toString(){
        return "Starting number: " + playerNumber+ "\nZawodnik: " + Name + " " + Surname +"\n";
    }



    public static Zawodnik findBestPlayer(){
        
        Zawodnik bestPlayer = Collections.min(extent, Comparator.comparing(s -> s.getPosition()));
        System.out.println("Best player is: " + bestPlayer.getName() +"    Place: " + bestPlayer.getPosition() +"\n");

        return bestPlayer; 
    }

    @Override
    public int getDochody() {
        // TODO Auto-generated method stub
        return 0;
    }
}