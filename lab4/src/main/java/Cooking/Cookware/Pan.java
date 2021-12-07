package Cooking.Cookware;

import Cooking.Exceptions.ColdPlaceToCook;
import Cooking.Ingredients.Ingredient;
import Cooking.Ingredients.IngredientStatus;
import Cooking.PlacesToCook.PlaceToCook;
import com.google.inject.Inject;

import java.util.List;

public class Pan extends Cookware{
    @Inject
    protected Pan(List<Ingredient> ingredients) {
        super(ingredients, "сковорода");
    }

    @Override
    public void use(PlaceToCook place) throws ColdPlaceToCook {
        if(place.isHeat()){
            for(Ingredient i: getIngredients()){
                i.setStatus(IngredientStatus.FRIED);
            }
        } else {
            System.out.println(place.getName() + " холодное");
            throw new ColdPlaceToCook();
        }
    }
}
