package Cooking.Cookware;

import Cooking.Exceptions.ColdPlaceToCook;
import Cooking.Ingredients.Ingredient;
import Cooking.PlacesToCook.PlaceToCook;
import Physical.PhysicalObject;

import java.util.Collections;
import java.util.List;

public abstract class Cookware extends PhysicalObject {
    private final List<Ingredient> ingredients;

    protected Cookware(List<Ingredient> ingredients, String name) {
        super(name);
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        System.out.println(ingredient.getName() + " оказывается в " + getName());
    }

    public abstract void use(PlaceToCook place) throws ColdPlaceToCook;

    public Ingredient removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
        return ingredient;
    }
}
