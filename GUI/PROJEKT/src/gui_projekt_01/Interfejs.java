package gui_projekt_01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interfejs extends JFrame implements ActionListener
{
    public static JButton button_wyjscie;

    public Interfejs()
    {    
        setVisible(true);
        setSize(1280,720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       

       button_wyjscie = new JButton("Wyjście");
       button_wyjscie.setBounds(20, 620, 150, 40);
       button_wyjscie.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                   System.exit(0);
                }
            });
       add(button_wyjscie);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}


    


