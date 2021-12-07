package Cooking.PlacesToCook;

import Cooking.Exceptions.UnableToFireFurnace;
import Physical.PhysicalObject;

public abstract class PlaceToCook extends PhysicalObject {
    private boolean isHeat;

    PlaceToCook(String name){
        super(name);
        isHeat = false;
    }

    public abstract void fire() throws UnableToFireFurnace;

    public abstract void putOut();

    public boolean isHeat() {
        return isHeat;
    }

    protected void setHeat(boolean heat) {
        isHeat = heat;
    }
}
