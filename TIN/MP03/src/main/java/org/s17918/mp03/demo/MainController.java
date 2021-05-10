package org.s17918.mp03.demo;

import org.s17918.mp03.demo.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private BeerRepository beerRepository;

    @RequestMapping(path="/recipes")
    public String list(Model model){
        model.addAttribute("beers", beerRepository.findAll());

        return "beers/recipes";
    }
}
