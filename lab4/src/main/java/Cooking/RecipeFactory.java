package Cooking;

import Cooking.Cookware.Cookware;
import Cooking.Ingredients.Ingredient;

import java.util.List;

public interface RecipeFactory {
    Recipe createRecipe(String dishName, List<Ingredient> ingredients, List<Instruction> instructions, Cookware cookware);
}
