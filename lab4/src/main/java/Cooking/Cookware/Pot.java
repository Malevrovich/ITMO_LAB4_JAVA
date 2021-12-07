package Cooking.Cookware;

import Cooking.Exceptions.ColdPlaceToCook;
import Cooking.Ingredients.Ingredient;
import Cooking.Ingredients.IngredientStatus;
import Cooking.Ingredients.Liquid.Liquid;
import Cooking.Ingredients.Liquid.LiquidTap;
import Cooking.PlacesToCook.PlaceToCook;
import Human.Human;
import com.google.inject.Inject;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

public class Pot extends Cookware{
    private Liquid mainLiquid;

    @Inject
    protected Pot(List<Ingredient> ingredients) {
        super(ingredients, "кастрюля");
    }

    public void fill(Liquid liquid){
        if(mainLiquid != null){
            System.out.println("Кастрюла занята");
            return;
        }

        mainLiquid = liquid;
        System.out.println(liquid.getName() + " попадает в " + getName());
    }

    public Liquid getMainLiquid() {
        return mainLiquid;
    }

    public Liquid pourOut(){
        Liquid res = mainLiquid;

        System.out.println(mainLiquid.getName() + " больше не в " + getName());
        mainLiquid = null;

        return res;
    }

    @Override
    public void use(PlaceToCook place) throws ColdPlaceToCook {
        if(place.isHeat()){
            for(Ingredient i: getIngredients()){
                i.setStatus(IngredientStatus.BOILED);
            }
        } else {
            System.out.println(place.getName() + " холодное");
            throw new ColdPlaceToCook();
        }
    }

    public Liquid fill(LiquidTap tap, Human human){
        Liquid liquid = tap.createLiquid();

        this.fill(liquid);
        this.forceBy(liquid);
        this.pourOut();

        liquid.disperse();
        liquid.fly();
        for(Human h: human.getCurrentPlace().getHumans()){
            liquid.attack(h);
        }
        return liquid;
    }
}
