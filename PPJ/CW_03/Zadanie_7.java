package CW_03;

public class Zadanie_7{
    public static void main(String[] args){
        
        boolean czyPada = true;
        boolean czySwieciSlonce = false;

        if(czyPada == true && czySwieciSlonce == false){
            System.out.println("PLUCHA");
        }else if(czyPada == true && czySwieciSlonce == true){
            System.out.println("TĘCZA");
        }else if(czyPada == false && czySwieciSlonce == true){
            System.out.println("SŁONECZNIE");
        }else if(czyPada == false && czySwieciSlonce == false){
            System.out.println("POCHMURNO");
        }
    }
}