package MP01;

/*
    Piotr Wasilewski
    S17918
*/


import java.util.ArrayList;

public class Program {

    Lokalizacja wisla = new Lokalizacja("Polska", "Wisła");
    Lokalizacja lillehammer = new Lokalizacja("Norwegia", "Lillehammer");
    Lokalizacja zakopane = new Lokalizacja("Polska", "Zakopane");
    Lokalizacja harrachov = new Lokalizacja("Czechy", "Harrachov");


    Obiekt skoczniaWisla = new Obiekt("Skocznia Adama Małysza", wisla, "145", 152);
    Obiekt skoczniaZakopane = new Obiekt("Skocznia Zakopane", zakopane, "165", 175);
    Obiekt skoczniaLillehammer = new Obiekt("Skocznia LilleHammer", lillehammer, "260", 267);
    Obiekt skoczniaHarrachov= new Obiekt("Skocznia Harrachov", harrachov, "185", 191);

    public static void main(String[] args) throws Exception {

    }

    public Zawodnik returnZawodnik(){
        return new Zawodnik("Adam", "Małysz", "Mężczyzna", "77120303547", 23, 349, 1, 80, 248);

    }

    public ArrayList<Trener> trenerzy(){
        ArrayList<Trener> trenerzyLista = new ArrayList<Trener>();
        trenerzyLista.add(new Trener("Paweł", "Kozak", "Mężczyzna", "69051201333", "15/05/2006", 3800));
        trenerzyLista.add(new Trener("Paweł", "Kozak", "Mężczyzna", "69051201333", "15/05/2006", 3800));
        trenerzyLista.add(new Trener("Paweł", "Kozak", "Mężczyzna", "69051201333", "15/05/2006", 3800));
        trenerzyLista.add(new Trener("Paweł", "Kozak", "Mężczyzna", "69051201333", "15/05/2006", 3800));
        trenerzyLista.add(new Trener("Paweł", "Kozak", "Mężczyzna", "69051201333", "15/05/2006", 3800));

        return(trenerzyLista);
    }

    public ArrayList<String> zawodyList(){
        Zawody zawody1 = new Zawody("Puchar Polski 2020", "12/12/2020", skoczniaWisla, "19:20", "22:00");
        Zawody zawody2 = new Zawody("Puchar Świata 2020", "23/12/2020", skoczniaLillehammer, "17:20", "19:45");
        Zawody zawody3 = new Zawody("Mistrzostwa powiatu Śląskiego", "15/01/2020", skoczniaWisla, "15:00", "16:30");
        Zawody zawody4 = new Zawody("Puchar Świata 2020", "20/01/2020", skoczniaHarrachov, "17:00", "19:25");
        Zawody zawody5 = new Zawody("Młodzieżowy puchar Polski", "02/02/2020", skoczniaZakopane, "16:20", "18:00");

        ArrayList<String> zawodyNazwy = new ArrayList<>();

        zawodyNazwy.add(zawody1.data + "  |  " + zawody1.nazwa);
        zawodyNazwy.add(zawody2.data + "  |  " + zawody2.nazwa);
        zawodyNazwy.add(zawody3.data + "  |  " + zawody3.nazwa);
        zawodyNazwy.add(zawody4.data + "  |  " + zawody4.nazwa);
        zawodyNazwy.add(zawody5.data + "  |  " + zawody5.nazwa);

        return zawodyNazwy;
    }

}