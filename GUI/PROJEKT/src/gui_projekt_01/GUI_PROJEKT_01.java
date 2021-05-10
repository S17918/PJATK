package gui_projekt_01;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

public class GUI_PROJEKT_01{
    
    public static void main(String[] args){
        
        
        ArrayList<Pomieszczenie> pomieszczenia_lista = new ArrayList<Pomieszczenie>();
        ArrayList<Osoba> osoby_lista = new ArrayList<Osoba>();
        
        Pomieszczenie pomieszczenie_1 = new Pomieszczenie("Pomieszczenie 1", 432, true, null, 0);
        Pomieszczenie pomieszczenie_2 = new Pomieszczenie("Pomieszczenie 2", 201, true, null, 0);
        Pomieszczenie pomieszczenie_3 = new Pomieszczenie("Pomieszczenie 3", 100, false, null, 0);
        Pomieszczenie pomieszczenie_4 = new Pomieszczenie("Pomieszczenie 4", 22, true, null, 0);
        Pomieszczenie pomieszczenie_5 = new Pomieszczenie("Pomieszczenie 5", 128, true, null, 0);
        Pomieszczenie pomieszczenie_6 = new Pomieszczenie("Pomieszczenie 6", 60, true, null, 0);
        Pomieszczenie pomieszczenie_7 = new Pomieszczenie("Pomieszczenie 7", 88, true, null, 0);
        Pomieszczenie pomieszczenie_8 = new Pomieszczenie("Pomieszczenie 8", 550, false, null, 0);
        Pomieszczenie pomieszczenie_9 = new Pomieszczenie("Pomieszczenie 9", 120, true, null, 0);
        Pomieszczenie pomieszczenie_10 = new Pomieszczenie("Pomieszczenie 10", 800, true, null, 0);
        Pomieszczenie pomieszczenie_11 = new Pomieszczenie("Pomieszczenie 11", 21, true, null, 0);
        Pomieszczenie pomieszczenie_12 = new Pomieszczenie("Pomieszczenie 12", 150, true, null, 0);
        Pomieszczenie pomieszczenie_13 = new Pomieszczenie("Pomieszczenie 13", 600, false, null, 0);
        Pomieszczenie pomieszczenie_14 = new Pomieszczenie("Pomieszczenie 14", 200, true, null, 0);
        Pomieszczenie pomieszczenie_15 = new Pomieszczenie("Pomieszczenie 15", 900, false, null, 0);
        
        Osoba oso1 = new Osoba("Ferdynand", "Szczepanski", "92032341734", "ul. Orłowicza Mieczysława 24 70-893 Szczecin", "1992-03-23", null);
        Osoba oso2 = new Osoba("Świętosław", "Wojciechowski", "89072238230", "ul. Senatorska 117 00-923 Warszawa", "1989-07-22", null);
        Osoba oso3 = new Osoba("Grażyna", "Zając", "95120519428", "ul. Płużnicka 113 03-184 Warszawa", "1995-12-05", null);
        Osoba oso4 = new Osoba("Zoja", "Sobczak", "79010145605", "ul. Chopina Fryderyka 110 42-506 Będzin", "1979-01-01", null);
        Osoba oso5 = new Osoba("Klemens", "Jasiński", "69062871870", "ul. Magnoliowa 142 20-143 Lublin", "1969-06-28", null);
        Osoba oso6 = new Osoba("Martyna", "Nowicka", "46122151400", "ul. Robotnicza 30 49-300 Brzeg", "1946-12-21", null);
        Osoba oso7 = new Osoba("Bartosz", "Czerwiński", "74021229698", "ul. Kłosowa 72 42-605 Tarnowskie Góry", "1974-02-12", null);
        Osoba oso8 = new Osoba("Jakub", "Czerwonka", "97042280499", "ul. Miączyn 10B 22-455 Miączyn", "1997-04-22", null);
        
        pomieszczenia_lista.add(pomieszczenie_1);
        pomieszczenia_lista.add(pomieszczenie_2);
        pomieszczenia_lista.add(pomieszczenie_3);
        pomieszczenia_lista.add(pomieszczenie_4);
        pomieszczenia_lista.add(pomieszczenie_5);
        pomieszczenia_lista.add(pomieszczenie_6);
        pomieszczenia_lista.add(pomieszczenie_7);
        pomieszczenia_lista.add(pomieszczenie_8);
        pomieszczenia_lista.add(pomieszczenie_9);
        pomieszczenia_lista.add(pomieszczenie_10);
        pomieszczenia_lista.add(pomieszczenie_11);
        pomieszczenia_lista.add(pomieszczenie_12);
        pomieszczenia_lista.add(pomieszczenie_13);
        pomieszczenia_lista.add(pomieszczenie_14);
        pomieszczenia_lista.add(pomieszczenie_15);
        

        osoby_lista.add(oso1);
        osoby_lista.add(oso2);
        osoby_lista.add(oso3);
        osoby_lista.add(oso4);
        osoby_lista.add(oso5);
        osoby_lista.add(oso6);
        osoby_lista.add(oso7);
        osoby_lista.add(oso8);
        
  
        
        Font myFont = new Font("Arial", Font.BOLD, 18);
        Interfejs okno1 = new Interfejs();
        okno1.setTitle("Zaloguj Się");
        JPanel okno1_panel = new JPanel();
        
            okno1.add(okno1_panel);
            okno1_panel.setLayout(null);
            
            
            Buttons osoba_1 = new Buttons();
            osoba_1.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo1);
            Buttons.bo1.setText(oso1.Imie + " " + oso1.Nazwisko);
            
            
            Buttons osoba_2 = new Buttons();
            osoba_2.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo2);
            Buttons.bo2.setText(oso2.Imie + " " + oso2.Nazwisko);
            
            Buttons osoba_3 = new Buttons();
            osoba_3.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo3);
            Buttons.bo3.setText(oso3.Imie + " " + oso3.Nazwisko);
            
            Buttons osoba_4 = new Buttons();
            osoba_4.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo4);
            Buttons.bo4.setText(oso4.Imie + " " + oso4.Nazwisko);
            
            Buttons osoba_5 = new Buttons();
            osoba_5.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo5); 
            Buttons.bo5.setText(oso5.Imie + " " + oso5.Nazwisko);
            
            Buttons osoba_6 = new Buttons();
            osoba_6.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo6);
            Buttons.bo6.setText(oso6.Imie + " " + oso6.Nazwisko);
            
            Buttons osoba_7 = new Buttons();
            osoba_7.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo7);
            Buttons.bo7.setText(oso7.Imie + " " + oso7.Nazwisko);
            
            Buttons osoba_8 = new Buttons();
            osoba_8.Buttons_osoby(osoby_lista, pomieszczenia_lista);
            okno1_panel.add(Buttons.bo8);
            Buttons.bo8.setText(oso8.Imie + " " + oso8.Nazwisko);
            
            
    }
    
}
