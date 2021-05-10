package mp03.s17918.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String recipeName;
    private String recipeRecipe;
    private Double recipePrice;

    public Recipe(){

    }

    public Recipe(String name, String recipe, Double price){
        this.recipeName = name;
        this.recipeRecipe = recipe;
        this.recipePrice = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeRecipe() {
        return recipeRecipe;
    }

    public void setRecipeRecipe(String recipeRecipe) {
        this.recipeRecipe = recipeRecipe;
    }

    public Double getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(Double recipePrice) {
        this.recipePrice = recipePrice;
    }
}
