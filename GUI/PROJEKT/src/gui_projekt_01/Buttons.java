package gui_projekt_01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Buttons extends JPanel{
    
    public static JButton bo1,bo2,bo3,bo4,bo5,bo6,bo7,bo8,button_wyloguj;
    public static JButton b_show_room, b_rent_room, b_room_ins, b_add, b_rem, b_save;
    
    public static Map<Pomieszczenie, ArrayList<Przedmiot>> mapa = new HashMap<Pomieszczenie, ArrayList<Przedmiot>>();
    public static Map<Osoba, ArrayList<Pomieszczenie>> mapa2 = new HashMap<Osoba, ArrayList<Pomieszczenie>>();
    
    public static ArrayList<Pomieszczenie> os_pomieszcz_1 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_2 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_3 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_4 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_5 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_6 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_7 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> os_pomieszcz_8 = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> lista_zajeta = new ArrayList<Pomieszczenie>();
    public static ArrayList<Pomieszczenie> pelna = new ArrayList<Pomieszczenie>();
    
    public static ArrayList<Przedmiot> lista_przedmiot_1 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_2 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_3 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_4 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_5 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_6 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_7 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_8 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_9 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_10 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_11 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_12 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_13 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_14 = new ArrayList<Przedmiot>();
    public static ArrayList<Przedmiot> lista_przedmiot_15 = new ArrayList<Przedmiot>();

    public static JPanel panel_g = new JPanel();
    
    public static Osoba o1, o2, o3, o4, o5, o6, o7, o8;
    
    
    
    

    public Buttons() {
    
        bo1 = new JButton();
        bo2 = new JButton();
        bo3 = new JButton();
        bo4 = new JButton();
        bo5 = new JButton();
        bo6 = new JButton();
        bo7 = new JButton();
        bo8 = new JButton();
        button_wyloguj = new JButton();
        b_show_room = new JButton();
        b_rent_room = new JButton();
        b_room_ins = new JButton();
        b_add = new JButton();
        b_rem = new JButton();
        b_save = new JButton();
        
        
        
    }
    public static void guziki(JPanel panel, Interfejs inter, ArrayList pom, ArrayList osoby){
       
        pelna.add((Pomieszczenie) pom.get(0));
        pelna.add((Pomieszczenie) pom.get(1));
        pelna.add((Pomieszczenie) pom.get(2));
        pelna.add((Pomieszczenie) pom.get(3));
        pelna.add((Pomieszczenie) pom.get(4));
        pelna.add((Pomieszczenie) pom.get(5));
        pelna.add((Pomieszczenie) pom.get(6));
        pelna.add((Pomieszczenie) pom.get(7));
        pelna.add((Pomieszczenie) pom.get(8));
        pelna.add((Pomieszczenie) pom.get(9));
        pelna.add((Pomieszczenie) pom.get(10));
        pelna.add((Pomieszczenie) pom.get(11));
        pelna.add((Pomieszczenie) pom.get(12));
        pelna.add((Pomieszczenie) pom.get(13));
        pelna.add((Pomieszczenie) pom.get(14));
        
        pom_dostęp(pom, lista_zajeta);
        
        b_show_room.setText("Pokaż Wolne Pomieszczenia");
            b_show_room.setBounds(1025, 20, 240, 40);
            panel.add(b_show_room);
            b_show_room.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    JFrame frame1 = new JFrame();
                    frame1.setVisible(true);
                    frame1.setSize(300,400);
                    frame1.setResizable(false);
                    JPanel panel = new JPanel();
                    frame1.add(panel);
                    frame1.setTitle("Wolne Pomieszczenia");
              
                    
                    JTextArea text = new JTextArea();
                    panel.add(text);
                    text.setBounds(40, 60, 490, 100);
                    text.setEditable(false);
                    Font myFont = new Font("Arial", Font.BOLD, 14);
                    text.setFont(myFont);
                    text.setText(pom.toString());    
                }
            });
            
            b_rent_room.setText("Wynajmij Pomieszczenie");
            b_rent_room.setBounds(1025, 80, 240, 40);
            panel.add(b_rent_room);
            b_rent_room.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    JFrame frame2 = new JFrame();
                    frame2.setVisible(true);
                    frame2.setSize(600,150);
                    frame2.setResizable(false);
                    
                    JPanel panel = new JPanel();
                    frame2.add(panel);
                    panel.setLayout(null);
                    JLabel thlabel = new JLabel("Wybierz Pomieszczenie: ");
                    panel.add(thlabel);
                    thlabel.setBounds(5, 20, 160, 20);
                    
                    JComboBox box = new JComboBox(new Vector(pom));
                    box.setBounds(170, 20, 200, 20);
                    panel.add(box);
                    
                    JLabel thlabel2 = new JLabel("Kim Jesteś: ");
                    panel.add(thlabel2);
                    thlabel2.setBounds(5, 60, 160, 20);
                    
                    JComboBox box2 = new JComboBox(new Vector(osoby));
                    box2.setBounds(170, 60, 200, 20);
                    panel.add(box2);
                    
                    JButton butwyn = new JButton();
                    butwyn.setBounds(400, 20, 150, 20);
                    butwyn.setText("Wynajmij");
                    panel.add(butwyn);
                    butwyn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                            Object pomieszcz = box.getSelectedItem();
                            Object oso = box2.getSelectedItem();
                            if(oso == osoby.get(0)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_1);
                                pokazPom(panel_g, o1, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(1)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_2);    
                                pokazPom(panel_g, o2, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(2)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_3);  
                                pokazPom(panel_g, o3, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(3)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_4);  
                                pokazPom(panel_g, o4, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(4)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_5);  
                                pokazPom(panel_g, o5, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(5)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_6);
                                pokazPom(panel_g, o6, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(6)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_7); 
                                pokazPom(panel_g, o7, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }else if(oso == osoby.get(7)){
                                wynajmij(oso, pomieszcz, pom, os_pomieszcz_8);    
                                pokazPom(panel_g, o8, osoby,os_pomieszcz_1, os_pomieszcz_2, os_pomieszcz_3, os_pomieszcz_4, os_pomieszcz_5, os_pomieszcz_6, os_pomieszcz_7, os_pomieszcz_8);
                                frame2.dispose();
                            }
                        
                        }
                    });
                   
                }
            });
            
            b_room_ins.setText("Wyświetl zawartość pomieszczenia");
            b_room_ins.setBounds(1025, 140, 240, 40);
            panel.add(b_room_ins);
            b_room_ins.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                    JFrame frame3 = new JFrame();
                    frame3.setVisible(true);
                    frame3.setSize(550,200);
                    frame3.setResizable(false);
                    
                    JPanel panel3 = new JPanel();
                    frame3.add(panel3);
                    panel3.setLayout(null);
                    
                    ArrayList<Pomieszczenie> odp = new ArrayList<Pomieszczenie>();
                    
                    if(o1 == osoby.get(0)){
                        odp = os_pomieszcz_1;
                    }else if(o2 == osoby.get(1)){
                        odp = os_pomieszcz_2;
                    }else if(o3 == osoby.get(2)){
                        odp = os_pomieszcz_3;
                    }else if(o4 == osoby.get(3)){
                        odp = os_pomieszcz_4;
                    }else if(o5 == osoby.get(4)){
                        odp = os_pomieszcz_5;
                    }else if(o6 == osoby.get(5)){
                        odp = os_pomieszcz_6;
                    }else if(o7 == osoby.get(6)){
                        odp = os_pomieszcz_7;
                    }else if(o8 == osoby.get(7)){
                        odp = os_pomieszcz_8;
                    }
                    
                    
                    JComboBox box2 = new JComboBox(new Vector(odp));
                    box2.setBounds(20, 20, 300, 20);
                    panel3.add(box2);
                    
                    JButton butshow = new JButton();
                    butshow.setBounds(360, 20, 150, 20);
                    butshow.setText("Wyświetl");
                    panel3.add(butshow);
                    butshow.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                            wyswietlPom(box2, pelna, panel3);
                        
                        }
                    });
                }
            });
            
            b_add.setText("Dodaj przedmiot");
            b_add.setBounds(1025, 200, 240, 40);
            panel.add(b_add);
            b_add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    
                    JFrame frame4 = new JFrame();
                    frame4.setVisible(true);
                    frame4.setSize(370,170);
                    frame4.setResizable(false);
                    JPanel panel = new JPanel();
                    frame4.add(panel);
                    panel.setLayout(null);
                    
                    JLabel firstlabel = new JLabel("Nazwa Przedmiotu: ");
                    panel.add(firstlabel);
                    firstlabel.setBounds(5, 10, 120, 20);
                    
                    JTextField text = new JTextField();
                    text.setBounds(130, 10, 200, 20);
                    text.setEditable(true);
                    panel.add(text);
                    
                    JLabel seclabel = new JLabel("Powierzchnia Przedmiotu: ");
                    panel.add(seclabel);
                    seclabel.setBounds(5, 40, 160, 20);
                   
                    JTextField text2 = new JTextField();
                    text2.setBounds(170, 40, 160, 20);
                    text2.setEditable(true);
                    panel.add(text2);
                    
                    JLabel thlabel = new JLabel("Wybierz Pomieszczenie: ");
                    panel.add(thlabel);
                    thlabel.setBounds(5, 70, 160, 20);
                    
                    ArrayList<Pomieszczenie> odp = new ArrayList<Pomieszczenie>();
                    
                    if(o1 == osoby.get(0)){
                        odp = os_pomieszcz_1;
                    }else if(o2 == osoby.get(1)){
                        odp = os_pomieszcz_2;
                    }else if(o3 == osoby.get(2)){
                        odp = os_pomieszcz_3;
                    }else if(o4 == osoby.get(3)){
                        odp = os_pomieszcz_4;
                    }else if(o5 == osoby.get(4)){
                        odp = os_pomieszcz_5;
                    }else if(o6 == osoby.get(5)){
                        odp = os_pomieszcz_6;
                    }else if(o7 == osoby.get(6)){
                        odp = os_pomieszcz_7;
                    }else if(o8 == osoby.get(7)){
                        odp = os_pomieszcz_8;
                    }
                    
                    
                    JComboBox box = new JComboBox(new Vector(odp));
                    box.setBounds(170, 70, 160, 20);
                    panel.add(box);
                    
                    JButton but = new JButton("Dodaj");
                    but.setBounds(5, 110, 100, 20);
                    panel.add(but);
                    but.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                            sprawdzCzyWejdzie(box, pelna, frame4, text, text2);
                        }
                    });

                    JButton but2 = new JButton("Anuluj");
                    but2.setBounds(110, 110, 100, 20);
                    panel.add(but2);
                    but2.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                            frame4.dispose();
                        }
                    });
                    
                }
            });
            
            b_rem.setText("Wyjmij przedmiot");
            b_rem.setBounds(1025, 260, 240, 40);
            panel.add(b_rem);
            b_rem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               
                    JFrame frame5 = new JFrame();
                    frame5.setVisible(true);
                    frame5.setSize(370,130);
                    frame5.setResizable(false);
                    JPanel panel = new JPanel();
                    frame5.add(panel);
                    panel.setLayout(null);
                    
                    JLabel firstlabel = new JLabel("Wybierz pokój: ");
                    panel.add(firstlabel);
                    firstlabel.setBounds(5, 10, 120, 20);
                    
                     ArrayList<Pomieszczenie> odp = new ArrayList<Pomieszczenie>();
                    
                    if(o1 == osoby.get(0)){
                        odp = os_pomieszcz_1;
                    }else if(o2 == osoby.get(1)){
                        odp = os_pomieszcz_2;
                    }else if(o3 == osoby.get(2)){
                        odp = os_pomieszcz_3;
                    }else if(o4 == osoby.get(3)){
                        odp = os_pomieszcz_4;
                    }else if(o5 == osoby.get(4)){
                        odp = os_pomieszcz_5;
                    }else if(o6 == osoby.get(5)){
                        odp = os_pomieszcz_6;
                    }else if(o7 == osoby.get(6)){
                        odp = os_pomieszcz_7;
                    }else if(o8 == osoby.get(7)){
                        odp = os_pomieszcz_8;
                    }
                               
                    JComboBox box = new JComboBox(new Vector(odp));
                    box.setBounds(130, 10, 200, 20);
                    panel.add(box);
                    
                    
                    JButton but = new JButton("Dalej");
                        but.setBounds(5, 70, 100, 20);
                        panel.add(but);
                        but.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                    Object o = box.getSelectedItem();
                                    if(o == pelna.get(0)){
                                        wyjmij(frame5, lista_przedmiot_1);
                                    }else if(o == pelna.get(1)){
                                        wyjmij(frame5, lista_przedmiot_2);
                                    }else if(o == pelna.get(2)){
                                        wyjmij(frame5, lista_przedmiot_3);
                                    }else if(o == pelna.get(3)){
                                        wyjmij(frame5, lista_przedmiot_4);
                                    }else if(o == pelna.get(4)){
                                        wyjmij(frame5, lista_przedmiot_5);
                                    }else if(o == pelna.get(5)){
                                        wyjmij(frame5, lista_przedmiot_6);
                                    }else if(o == pelna.get(6)){
                                        wyjmij(frame5, lista_przedmiot_7);
                                    }else if(o == pelna.get(7)){
                                        wyjmij(frame5, lista_przedmiot_8);
                                    }else if(o == pelna.get(8)){
                                        wyjmij(frame5, lista_przedmiot_9);
                                    }else if(o == pelna.get(9)){
                                        wyjmij(frame5, lista_przedmiot_10);
                                    }else if(o == pelna.get(10)){
                                        wyjmij(frame5, lista_przedmiot_11);
                                    }else if(o == pelna.get(11)){
                                        wyjmij(frame5, lista_przedmiot_12);
                                    }else if(o == pelna.get(12)){
                                        wyjmij(frame5, lista_przedmiot_13);
                                    }else if(o == pelna.get(13)){
                                        wyjmij(frame5, lista_przedmiot_14);
                                    }else if(o == pelna.get(14)){
                                        wyjmij(frame5, lista_przedmiot_15);
                                    }
                                }
                            });
                                               
                    
                    JButton but2 = new JButton("Anuluj");
                    but2.setBounds(110, 70, 100, 20);
                    panel.add(but2);
                    but2.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                            frame5.dispose();
                        }
                    });
                   
                }
            });
            
            b_save.setText("Zapisz do pliku");
            b_save.setBounds(1025, 620, 240, 40);
            panel.add(b_save);
            b_save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    String nazwa = "Magazyn_stan.txt";
                    PrintWriter magazyn = new PrintWriter(nazwa);
                    
                    for(Osoba o: mapa2.keySet()){
                        magazyn.println(o + " " + mapa2.get(o));
                    }
                    
                    magazyn.println(" ");
                    
                    for(Pomieszczenie p: mapa.keySet()){
                        magazyn.println(p + " " + mapa.get(p));
                    }
                    
                    
                    magazyn.close();
                    System.out.println("Zapisano stan magazynu do pliku o nazwie: " + nazwa);
                } catch (FileNotFoundException ex) {
                    System.out.println("Nie znaleziono pliku");
                }
                   
                }
            });
            
            
            
            Interfejs.button_wyjscie.setBounds(20, 620, 150, 40);
            panel.add(Interfejs.button_wyjscie);
            
                 
    }
    

    
    

    public void Buttons_osoby(ArrayList osoby, ArrayList pom){
        
        
        
        
        bo1.setBounds(20, 20, 300, 40);
        bo1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(0), pom, osoby, panel_g);
                    o1 = (Osoba) osoby.get(0);
            }
        });
        add(bo1);
        
        bo2.setBounds(20, 80, 300, 40);
        bo2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(1), pom, osoby, panel_g);
                o2 = (Osoba) osoby.get(1);
            }
        });
        add(bo2);
        
        bo3.setBounds(20, 140, 300, 40);
        bo3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(2), pom, osoby, panel_g);
                o3 = (Osoba) osoby.get(2);
            }
        });
        add(bo3);
        
        bo4.setBounds(20, 200, 300, 40);
        bo4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(3), pom, osoby, panel_g);
                o4 = (Osoba) osoby.get(3);
            }
        });
        add(bo4);
        
        bo5.setBounds(20, 260, 300, 40);
        bo5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(4), pom, osoby, panel_g);
                o5 = (Osoba) osoby.get(4);
            }
        });
        add(bo5);
        
        bo6.setBounds(20, 320, 300, 40);
        bo6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(5), pom, osoby, panel_g);
                o6 = (Osoba) osoby.get(5);
            }
        });
        add(bo6);
        
        bo7.setBounds(20, 380, 300, 40);
        bo7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(6), pom, osoby, panel_g);
                o7 = (Osoba) osoby.get(6);
            }
        });
        add(bo7);
        
        bo8.setBounds(20, 440, 300, 40);
        bo8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                panel((Osoba) osoby.get(7), pom, osoby, panel_g);
                o8 = (Osoba) osoby.get(7);
            }
        });
        add(bo8);
    }
    
    
    
    public static Map<Pomieszczenie, ArrayList<Przedmiot>> sprawdzCzyWejdzie(JComboBox box, ArrayList pomieszczenie, JFrame frame, JTextField text, JTextField text2){
        
        String pow = text2.getText();
        int powierz = Integer.parseInt(pow);
        Object o = box.getSelectedItem();
        int powierzchnia_ogol = 0;
        powierzchnia_ogol += powierz;
     
        
        String nazwa = text.getText();
        
        if(o == pomieszczenie.get(0)){
          //  if(Pomieszczenie.sprawdz((Pomieszczenie) o) <= powierz){
            lista_przedmiot_1.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_1);
          //  }else{
           //     System.out.println("Nie dodano przedmiotu - za mało miejsca w pomieszczeniu");
           // }
        }else if(o == pomieszczenie.get(1)){
            lista_przedmiot_2.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_2);
        }else if(o == pomieszczenie.get(2)){
            lista_przedmiot_3.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_3);
        }else if(o == pomieszczenie.get(3)){
            lista_przedmiot_4.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_4);
        }else if(o == pomieszczenie.get(4)){
            lista_przedmiot_5.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_5);
        }else if(o == pomieszczenie.get(5)){
            lista_przedmiot_6.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_6);
        }else if(o == pomieszczenie.get(6)){
            lista_przedmiot_7.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_7);
        }else if(o == pomieszczenie.get(7)){
            lista_przedmiot_8.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_8);
        }else if(o == pomieszczenie.get(8)){
            lista_przedmiot_9.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_9);
        }else if(o == pomieszczenie.get(9)){
            lista_przedmiot_10.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_10);
        }else if(o == pomieszczenie.get(10)){
            lista_przedmiot_11.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_11);
        }else if(o == pomieszczenie.get(11)){
            lista_przedmiot_12.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_12);
        }else if(o == pomieszczenie.get(12)){
            lista_przedmiot_13.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_13);
        }else if(o == pomieszczenie.get(13)){
            lista_przedmiot_14.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_14);
        }else if(o == pomieszczenie.get(14)){
            lista_przedmiot_15.add(new Przedmiot(nazwa, powierz));
            mapa.put((Pomieszczenie) o, lista_przedmiot_15);
        }
        
      
        
        System.out.println("Dodano przedmiot: " + nazwa + "\nPowierzchnia: " + powierz +"\n" + o + "\n");
        frame.dispose();    
        
        return mapa;
        
    }
    
    public static void wyswietlPom(JComboBox box, ArrayList pomieszczenie, JPanel panel){
        Object o = box.getSelectedItem();
        
        for(Map.Entry<Pomieszczenie, ArrayList<Przedmiot>> entry : mapa.entrySet()){
            
            if(o.equals(entry.getKey())){
                
                Pomieszczenie key = entry.getKey();
                ArrayList<Przedmiot> values = entry.getValue();
                
                JTextArea text = new JTextArea();
                panel.add(text);
                text.setBounds(20, 60, 490, 100);
                text.setEditable(false);
                Font myFont = new Font("Arial", Font.BOLD, 14);
                text.setFont(myFont);
                text.setText(values.toString());
            
            }
            
        }
    }
    
    public static void panel(Osoba o, ArrayList pom, ArrayList osoby, JPanel panel){
        try {
            Interfejs inter1 = new Interfejs();
            inter1.setTitle(o.Imie + " " + o.Nazwisko);
            inter1.setVisible(true);
            inter1.add(panel);
            panel.setLayout(null);
            
            guziki(panel, inter1, pom, osoby);
            Czas.ShowCzas(panel);
            
            JTextArea text = new JTextArea();
            text.setBounds(20, 20, 990, 160);
            text.setEditable(false);
            Font myFont = new Font("Arial", Font.BOLD, 18);
            text.setFont(myFont);
            panel.add(text);
            
            text.setText(Osoba.ShowOsoba(o) + "\n\n" + 
                    " Moje Pomieszczenia: "); 
            
            
            
            
            
            
        } catch (NeverRentException ex) {
            System.out.println("Nie wynajęto pomieszczenia");
        }
        
    }
    
    public static void wyjmij(JFrame frame5, ArrayList lista){
        JFrame frame5_1 = new JFrame();
        frame5_1.setVisible(true);
        frame5_1.setSize(370,130);
        frame5_1.setResizable(false);
        JPanel panel = new JPanel();
        frame5_1.add(panel);
        panel.setLayout(null);
                    
        JLabel firstlabel = new JLabel("Wybierz przedmiot: ");
        panel.add(firstlabel);
        firstlabel.setBounds(5, 10, 120, 20);
                               
        JComboBox box = new JComboBox(new Vector(lista));
        box.setBounds(130, 10, 200, 20);
        panel.add(box);
        Object obj = box.getSelectedItem();
        JButton but = new JButton("Wyjmij");
        but.setBounds(5, 70, 100, 20);
        panel.add(but);
        but.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
                        
            lista.remove(obj);
            System.out.println("Wyjęto przedmiot: " +obj.toString()+"\n");
            frame5_1.dispose();
            frame5.dispose();
            }
        });
    }
    
    public static void pom_dostęp(ArrayList lista_cała, ArrayList lista_zajeta){
        
        for(int i = 0; i<lista_cała.size(); i++){
            Pomieszczenie p = (Pomieszczenie) lista_cała.get(i);
            if(p.Dostepnosc == false){
                lista_zajeta.add(p);
                lista_cała.remove(p);
            }
        }
    }
    
    public static void wynajmij(Object o, Object p, ArrayList pom, ArrayList pomiesz){
        pomiesz.add((Pomieszczenie) p);
        mapa2.put((Osoba) o, pomiesz);
        lista_zajeta.add((Pomieszczenie) p);
        pom.remove((Pomieszczenie)p);
        System.out.println("Wynajęto pomieszczenie: "+p);
    }
    
    public static void pokazPom(JPanel panel, Object o, ArrayList<Osoba> osoby, ArrayList<Pomieszczenie> os_pomieszcz_1, ArrayList<Pomieszczenie> os_pomieszcz_2, ArrayList<Pomieszczenie> os_pomieszcz_3, ArrayList<Pomieszczenie> os_pomieszcz_4, ArrayList<Pomieszczenie> os_pomieszcz_5, ArrayList<Pomieszczenie> os_pomieszcz_6, ArrayList<Pomieszczenie> os_pomieszcz_7, ArrayList<Pomieszczenie> os_pomieszcz_8) {
        if((Osoba)o == osoby.get(0)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_1.toString());
        }if((Osoba)o == osoby.get(1)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_2.toString());
        }if((Osoba)o == osoby.get(2)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_3.toString());
        }if((Osoba)o == osoby.get(3)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_4.toString());
        }if((Osoba)o == osoby.get(4)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_5.toString());
        }if((Osoba)o == osoby.get(5)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_6.toString());
        }if((Osoba)o == osoby.get(6)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_7.toString());
        }if((Osoba)o == osoby.get(7)){
            JTextArea text = new JTextArea();
            panel.add(text);
            Font myFont = new Font("Arial", Font.BOLD, 14);
            text.setFont(myFont);
            text.setBounds(20, 180, 990, 100);
            text.setEditable(false);
            text.setText(os_pomieszcz_8.toString());
        }
    }
    
    public static ArrayList<Pomieszczenie> box(Osoba o1, Osoba o2, Osoba o3, Osoba o4, Osoba o5, Osoba o6, Osoba o7, Osoba o8, ArrayList osoby){
        ArrayList<Pomieszczenie> odp = new ArrayList<Pomieszczenie>();
        
        if(o1 == osoby.get(0)){
            odp = os_pomieszcz_1;
        }else if(o2 == osoby.get(1)){
            odp = os_pomieszcz_2;
        }else if(o3 == osoby.get(2)){
            odp = os_pomieszcz_3;
        }else if(o4 == osoby.get(3)){
            odp = os_pomieszcz_4;
        }else if(o5 == osoby.get(4)){
            odp = os_pomieszcz_5;
        }else if(o6 == osoby.get(5)){
            odp = os_pomieszcz_6;
        }else if(o7 == osoby.get(6)){
            odp = os_pomieszcz_7;
        }else if(o8 == osoby.get(7)){
            odp = os_pomieszcz_8;
        }
        return odp;
    }
}
