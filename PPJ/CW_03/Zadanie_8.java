package CW_03;

public class Zadanie_8{
    public static void main(String[] args){
        
        boolean czyPada = false;
        boolean czySwieciSlonce = false;
        int x = 0; 

        if(czyPada == true && czySwieciSlonce == false){
            System.out.println("PLUCHA");
            x = 5; 
        }else if(czyPada == true && czySwieciSlonce == true){
            System.out.println("TĘCZA");
            x = 5;
        }else if(czyPada == false && czySwieciSlonce == true){
            System.out.println("SŁONECZNIE");
            x = 8;
        }else if(czyPada == false && czySwieciSlonce == false){
            System.out.println("POCHMURNO");
            x = 8;
        }

        System.out.println(x);
    }
}