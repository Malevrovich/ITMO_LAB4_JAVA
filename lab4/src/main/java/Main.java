import Cooking.Cookware.Pot;
import Cooking.Exceptions.ColdPlaceToCook;
import Cooking.Exceptions.IncorrectCookware;
import Cooking.Exceptions.UnableToFireFurnace;
import Cooking.Ingredients.BulkIngredient;
import Cooking.Ingredients.Ingredient;
import Cooking.Ingredients.IngredientFactory;
import Cooking.Ingredients.Liquid.WaterTap;
import Cooking.Instruction;
import Cooking.PlacesToCook.Furnace;
import Cooking.PlacesToCook.PlaceToCook;
import Cooking.Recipe;
import Cooking.RecipeFactory;
import Human.Heroes.Shpuntik;
import Human.Heroes.Vintik;
import Human.Heroes.Znaika;
import Physical.*;
import Physical.Position.PositionEngine;
import Physical.Position.RelativePos;
import PlaceMap.Door.Door;
import PlaceMap.Door.DoorWithLock;
import Torpedo.TorpedoVisitor;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void findAndGo(Vintik vintik, String place_name){
        for(Door door: vintik.getCurrentPlace().getDoors()){
            if(door.getRhs().equals(place_name) || door.getLhs().equals(place_name)){
                door.open();
                door.go(vintik);
                return;
            }
        }
    }

    public static void act1(Vintik vintik, Shpuntik shpuntik, Znaika znaika){
        System.out.println("Акт 1:\n");
        vintik.talkTo(znaika);
        shpuntik.talkTo(znaika);
        znaika.getCurrentPlace().getDoors().get(0).open().go(znaika);
    }

    public static void act2(Vintik vintik, Shpuntik shpuntik){
        System.out.println("Акт 2:\n");
        Injector injector = Guice.createInjector(new Module());
        RecipeFactory recipeFactory = injector.getInstance(RecipeFactory.class);

        IngredientFactory ingredientFactory = injector.getInstance(IngredientFactory.class);
        List<Ingredient> ingredients = new LinkedList<>();

        BulkIngredient flour = ingredientFactory.createBulkIngredient("мука");
        ingredients.add(ingredientFactory.createPackOfIngredient(flour));

        BulkIngredient groats = ingredientFactory.createBulkIngredient("крупа");
        ingredients.add(ingredientFactory.createPackOfIngredient(groats));

        BulkIngredient sugar = ingredientFactory.createBulkIngredient("сахар");
        ingredients.add(ingredientFactory.createPackOfIngredient(sugar));

        BulkIngredient vermicelli = ingredientFactory.createBulkIngredient("вермишель");
        ingredients.add(ingredientFactory.createPackOfIngredient(vermicelli));

        Pot pot = injector.getInstance(Pot.class);

        List<Instruction> instructionList = new LinkedList<>();
        instructionList.add(Instruction.FILL_POT_WITH_WATER);
        instructionList.add(Instruction.ADD_TO_POT);
        instructionList.add(Instruction.FIRE);
        instructionList.add(Instruction.BOIL);

        Recipe breakfastRecipe = recipeFactory.createRecipe("завтрак", ingredients, instructionList, pot);

        PlaceToCook plate = injector.getInstance(Furnace.class);

        WaterTap tap = injector.getInstance(WaterTap.class);

        try {
            breakfastRecipe.cook(ingredients, plate, tap, shpuntik);
        } catch (IncorrectCookware e){
            System.out.println(breakfastRecipe.getDishName() + " не удался - нет " + breakfastRecipe.getCookware().getName());
        } catch (ColdPlaceToCook c){
            c.printStackTrace();
        } catch (UnableToFireFurnace u){
            System.out.println(u.getMessage());
            System.out.println(u.getCause().getMessage());
        }
    }

    public static void act3(Vintik vintik){
        System.out.println("\nАкт 3: \n");
        vintik.getClothes().get(0).takeOff(vintik);

        for(PhysicalObject o: vintik.getCurrentPlace().getItems()){
            if(o.getName().equals("стол")){
                o.forceBy(vintik);
            }
        }

        findAndGo(vintik, "коридор");
    }

    public static void act4(Vintik vintik){
        System.out.println("\nАкт 4: \n");
        for(PhysicalObject i: vintik.getCurrentPlace().getItems()){
            i.forceBy(vintik);
        }

        for(int c = 0; c < 3; c++) {
//            for (PhysicalObject i : screw.getCurrentPlace().getElements()) {
//                i.forceBy(screw);
//            }

            for (Door d: vintik.getCurrentPlace().getDoors()){
                if(d.getRhs().equals("двор") || d.getLhs().equals("двор")){
                    d.forceBy(vintik);
                }
            }
        }

        for(PlaceElement el: vintik.getCurrentPlace().getElements()){
            if(el.getName().equals("пол")){
                el.makeLeaned(vintik);
                break;
            }
        }

        for(Door door: vintik.getCurrentPlace().getDoors()){
            if(door.getLhs().equals("двор") || door.getRhs().equals("двор")){
                ((DoorWithLock)door).pullTheHandle(vintik);
                door.go(vintik);
            }
        }

        findAndGo(vintik, "двор");
    }

    public static void act5(Vintik vintik, PositionEngine engine){
        System.out.println("\nАкт 5: \n");
        vintik.fire(new TorpedoVisitor());

        Item summer_house = null;
        for(PhysicalObject i: vintik.getCurrentPlace().getItems()){
            if(i.getName().equals("беседка")){
                summer_house = (Item) i;
                break;
            }
        }
        engine.setPosition(vintik, summer_house, RelativePos.ABOVE);

        Item fence = null;
        for(PhysicalObject i: vintik.getCurrentPlace().getItems()){
            if(i.getName().equals("забор")){
                fence = (Item) i;
                break;
            }
        }

        engine.setPosition(vintik, fence, RelativePos.BEHIND);
    }

    public static void main(String[] args) {
        // Init...
        System.out.println("Инициализация:");
        Injector injector = Guice.createInjector(new Module());

        PositionEngine engine = injector.getInstance(PositionEngine.class);

        Vintik vintik = injector.getInstance(Vintik.class);
        Shpuntik shpuntik = injector.getInstance(Shpuntik.class);
        Znaika znaika = injector.getInstance(Znaika.class);

        PhysicalFactory physicalFactory = injector.getInstance(PhysicalFactory.class);
        Wearable shoes = physicalFactory.createWearable("ботинки");
        for(PlaceElement el: vintik.getCurrentPlace().getElements()){
            if(el.getName().equals("пол")){
                el.makeNailed(shoes, engine);
            }
        }
        shoes.takeOn(vintik);

        System.out.println();

        act1(vintik, shpuntik, znaika);
        act2(vintik, shpuntik);
        act3(vintik);
        act4(vintik);
        act5(vintik, engine);
    }
}
