package mp03.s17918;

import mp03.s17918.Repositories.BeerRepository;
import mp03.s17918.Repositories.RecipeRepository;
import mp03.s17918.models.Beer;
import mp03.s17918.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private RecipeRepository recipeRepository;



    @RequestMapping(path="/recipes")
    public String recipes(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("beers", beerRepository.findAll());
        model.addAttribute("recipe", recipe);
        return "recipes";
    }

    @RequestMapping(path="/index")
    public String index(Model model){
        model.addAttribute("beers", beerRepository.findAll());
        return "index";
    }

    @RequestMapping(path="/add")
    public String addBeer(Model model){
        Beer beer = new Beer();
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("beer", beer);
        return "add_beer_recipe";
    }

    @RequestMapping(path="/edit")
    public String editBeer(Model model){
        Beer beer = new Beer();
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("beer", beer);
        return "edit_beer_recipe";
    }

    @RequestMapping(path="/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping(path="/top3")
    public String top3(Model model){
        model.addAttribute("beers", beerRepository.findAll());
        return "top3";
    }

    @RequestMapping(path="/beer_detail/{id_1}/{id_2}")
    public String beer_detail(@PathVariable("id_1") long id_1, @PathVariable("id_2") long id_2 , Model model){
        Beer beer = beerRepository.findById(id_1)
                .orElseThrow(() -> new IllegalArgumentException("Invalid beer Id:" + id_1));
        Recipe recipe = recipeRepository.findById(id_2)
                .orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id_2));

        model.addAttribute("recipe", recipe);
        model.addAttribute("beer", beer);
        return "polskie_jasne";
    }

    @PostMapping("/add_beer")
    public String add_Beer(Beer beer, Recipe recipe, Model model){
        beerRepository.save(beer);
        recipeRepository.save(recipe);

        model.addAttribute("recipe", recipeRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("beer", beerRepository.findAll());
        model.addAttribute("beers", beerRepository.findAll());
        return "recipes";    }

    @GetMapping("/edit/{id_1}/{id_2}")
    public String showUpdateBeer(@PathVariable("id_1") long id_1, @PathVariable("id_2") long id_2 , Model model){
        Beer beer = beerRepository.findById(id_1)
                .orElseThrow(() -> new IllegalArgumentException("Invalid beer Id:" + id_1));
        Recipe recipe = recipeRepository.findById(id_2)
                .orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id_2));

        model.addAttribute("beer", beer);
        model.addAttribute("recipe", recipe);
        return("edit_beer_recipe");
    }

    @GetMapping("/delete/{id_1}/{id_2}")
    public String deleteBeer(@PathVariable("id_1") long id_1, @PathVariable("id_2") long id_2, Model model){
        Beer beer = beerRepository.findById(id_1)
                .orElseThrow(() -> new IllegalArgumentException("Invalid beer Id:" + id_1));
        Recipe recipe = recipeRepository.findById(id_2)
                .orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id_2));


        beerRepository.delete(beer);
        recipeRepository.delete(recipe);

        model.addAttribute("beers", beerRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes";
    }

    @PostMapping("/update/{id_1}/{id_2}")
    public String updateBeer(@PathVariable("id_1") long id_1, @PathVariable("id_2") long id_2, Beer beer, Recipe recipe, Model model){
        beer.setId(id_1);
        recipe.setId(id_2);

        beerRepository.save(beer);
        recipeRepository.save(recipe);

        model.addAttribute("recipe", recipeRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("beer", beerRepository.findAll());
        model.addAttribute("beers", beerRepository.findAll());
        return "recipes";    }
}
