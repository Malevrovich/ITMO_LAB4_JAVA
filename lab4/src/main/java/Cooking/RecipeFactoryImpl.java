package Cooking;

import Cooking.Cookware.Cookware;
import Cooking.Ingredients.Ingredient;

import java.util.List;

public class RecipeFactoryImpl implements RecipeFactory{
    @Override
    public Recipe createRecipe(String dishName, List<Ingredient> ingredients, List<Instruction> instructions, Cookware cookware) {
        return new Recipe(dishName, ingredients, instructions, cookware);
    }
}
