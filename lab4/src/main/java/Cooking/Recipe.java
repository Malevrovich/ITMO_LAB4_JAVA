package Cooking;

import Cooking.Cookware.Cookware;
import Cooking.Cookware.Pan;
import Cooking.Cookware.Pot;
import Cooking.Exceptions.ColdPlaceToCook;
import Cooking.Exceptions.IncorrectCookware;
import Cooking.Exceptions.UnableToFireFurnace;
import Cooking.Ingredients.BulkIngredient;
import Cooking.Ingredients.Ingredient;
import Cooking.Ingredients.Liquid.Liquid;
import Cooking.Ingredients.Liquid.LiquidTap;
import Cooking.Ingredients.PackOfIngredient;
import Cooking.PlacesToCook.PlaceToCook;
import Human.Human;

import java.util.Collections;
import java.util.List;

public class Recipe {
    private final String dishName;
    private final List<Ingredient> neededIngredients;
    private final List<Instruction> instructions;
    private final Cookware cookware;

    public Recipe(String dishName, List<Ingredient> ingredients, List<Instruction> instructions, Cookware cookware) {
        this.dishName = dishName;
        this.cookware = cookware;

        Collections.sort(ingredients);
        this.neededIngredients = ingredients;

        this.instructions = instructions;
    }

    public Dish cook(List<Ingredient> ingredients, PlaceToCook place, LiquidTap tap, Human human)
            throws IncorrectCookware, ColdPlaceToCook, UnableToFireFurnace {
        System.out.println(human.getName() + " готовит " + getDishName());
        if(!ingredients.equals(neededIngredients)){
            System.out.println("Не хватает игредиентов для приготовления " + dishName);
        }
        for(Instruction instruction: instructions){
            System.out.println("\n" + human.getName() + " " + instruction.getPhrase());
            switch (instruction){
                case FIRE:
                    place.fire();
                    break;
                case FILL_POT_WITH_WATER:
                    if(cookware instanceof Pot){
                        if(tap != null){
                            Liquid liquid = ((Pot) cookware).fill(tap, human);
                            ((Pot) cookware).fill(liquid);
                        }
                    } else{
                        System.out.println("Не во что наливать");
                        throw new IncorrectCookware(Pot.class.getName());
                    }
                    break;
                case FRY:
                    if(cookware instanceof Pan){
                        cookware.use(place);
                    } else{
                        System.out.println("Не на чем жарить");
                        throw new IncorrectCookware(Pan.class.getName());
                    }
                    break;
                case BOIL:
                    if(cookware instanceof Pot){
                        cookware.use(place);
                    } else{
                        System.out.println("Не на чем варить");
                        throw new IncorrectCookware(Pot.class.getName());
                    }
                    break;
                case ADD_TO_POT:
                    if(cookware instanceof Pot){
                        for(Ingredient i: ingredients){
                            if(i instanceof PackOfIngredient){
                                BulkIngredient bulk = ((PackOfIngredient) i).unpack(human);
                                bulk.gatherIn((Pot) cookware);
                                ((PackOfIngredient) i).close(human);
                            } else{
                                cookware.addIngredient(i);
                            }
                        }
                        ingredients = Collections.emptyList();
                    } else {
                        System.out.println("Некуда складывать");
                        throw new IncorrectCookware(Pot.class.getName());
                    }
                    break;
            }
        }
        return new Dish(dishName);
    }

    public List<Ingredient> getNeededIngredients() {
        return Collections.unmodifiableList(neededIngredients);
    }

    public List<Instruction> getInstructions() {
        return Collections.unmodifiableList(instructions);
    }

    public String getDishName() {
        return dishName;
    }

    public Cookware getCookware() {
        return cookware;
    }
}
