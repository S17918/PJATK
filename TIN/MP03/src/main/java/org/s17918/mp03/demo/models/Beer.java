package org.s17918.mp03.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;

    private String Ingriedients;

    private Float Alcohol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIngriedients() {
        return Ingriedients;
    }

    public void setIngriedients(String ingriedients) {
        Ingriedients = ingriedients;
    }

    public Float getAlcohol() {
        return Alcohol;
    }

    public void setAlcohol(Float alcohol) {
        Alcohol = alcohol;
    }
}
