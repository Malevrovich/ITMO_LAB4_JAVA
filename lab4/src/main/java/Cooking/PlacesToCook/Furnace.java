package Cooking.PlacesToCook;

import Air.AirEngine;
import Cooking.Exceptions.NoOxygenNearFurnace;
import Cooking.Exceptions.UnableToFireFurnace;
import com.google.inject.Inject;

public class Furnace extends PlaceToCook{
    private final Fire fire;

    @Inject
    Furnace(Fire fire) {
        super("печь");
        this.fire = fire;
    }

    @Override
    public void fire() throws UnableToFireFurnace {
        try{
            fire.fire(this);
            setHeat(true);
        } catch (NoOxygenNearFurnace noOxygenNearFurnace) {
            throw new UnableToFireFurnace("не удалось зажечь печку", noOxygenNearFurnace);
        }
    }

    @Override
    public void putOut() {
        System.out.println("NOT YET IMPLEMENTED");
    }
}
