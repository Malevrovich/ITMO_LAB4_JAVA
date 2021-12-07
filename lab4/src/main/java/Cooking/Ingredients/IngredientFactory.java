package Cooking.Ingredients;

import Cooking.Ingredients.Liquid.Liquid;

public interface IngredientFactory {
    Liquid createLiquid(String name);
    BulkIngredient createBulkIngredient(String name);
    PackOfIngredient createPackOfIngredient(BulkIngredient content);
    SolidIngredient createSolidIngredient(String name);
}
