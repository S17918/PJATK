

function checkName() {
    var beerName = document.forms["addBeer"]["beerName"].value;
    var beerAlcohol = document.forms["addBeer"]["beerAlcohol"].value;
    var beerOpis = document.forms["addBeer"]["beerOpis"].value;
    var beerIngridients = document.forms["addBeer"]["beerIngridients"].value;
    var recipeName = document.forms["addBeer"]["recipeName"].value;
    var recipePrice = document.forms["addBeer"]["recipePrice"].value;
    var recipeRecipe = document.forms["addBeer"]["recipeRecipe"].value;

    if(beerName === "" || beerName == null){
        alert("Podaj nazwę piwa");
        return false;
    }
    if(beerAlcohol === "" || beerAlcohol == null){
        alert("Podaj zawartość alkoholu");
        return false;
    }
    if(beerOpis === "" || beerOpis == null){
        alert("Podaj opis piwa");
        return false;
    }
    if(beerIngridients === "" || beerIngridients == null){
        alert("Podaj składniki piwa");
        return false;
    }
    if(recipeName === "" || recipeName == null){
        alert("Podaj nazwę przepisu");
        return false;
    }
    if(recipeRecipe === "" || recipeRecipe == null){
        alert("Podaj przepis");
        return false;
    }
    if(recipePrice === "" || recipePrice == null){
        alert("Podaj cenę przepisu");
        return false;
    }
}