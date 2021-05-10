package gui_projekt_01;

public class NeverRentException extends Exception{

    public NeverRentException() {
        System.out.println("Nie wynajęto pomieszczenia");
    }
    
}
