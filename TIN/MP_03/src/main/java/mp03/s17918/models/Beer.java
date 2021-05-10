package mp03.s17918.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String beerName;
    private String beerOpis;
    private String beerIngriedients;
    private Float beerAlcohol;

    public Beer(){

    }

    public Beer(String name, String opis, String ingriedients, Float alcohol){
        this.beerName = name;
        this.beerOpis = opis;
        this.beerIngriedients = ingriedients;
        this.beerAlcohol = alcohol;
    }

    public String getOpis() {
        return beerOpis;
    }

    public void setOpis(String opis) {
        beerOpis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return beerName;
    }

    public void setName(String name) {
        beerName = name;
    }

    public String getIngriedients() {
        return beerIngriedients;
    }

    public void setIngriedients(String ingriedients) {
        beerIngriedients = ingriedients;
    }

    public Float getAlcohol() {
        return beerAlcohol;
    }

    public void setAlcohol(Float alcohol) {
        beerAlcohol = alcohol;
    }
}
