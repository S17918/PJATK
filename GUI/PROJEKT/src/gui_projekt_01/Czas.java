package gui_projekt_01;

import java.awt.Font;
import java.time.LocalDate;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.time.LocalTime;

public class Czas{
    
    static LocalDate localDate = LocalDate.now();
    static LocalTime localTime = LocalTime.now();
    
    public static void ShowCzas(JPanel panel){
        JTextArea text = new JTextArea();
        text.setBounds(660, 630, 350, 20);
        text.setEditable(false);
        Font myFont = new Font("Arial", Font.BOLD, 18);
        text.setFont(myFont);
        panel.add(text);
        int x = 0;
        localDate = LocalDate.now().plusDays(x);
        text.setText(" Data: " + localDate + "      Czas: " + localTime);
    }
    
}


