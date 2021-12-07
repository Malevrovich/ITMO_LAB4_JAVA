package Cooking.PlacesToCook;

import com.google.inject.Inject;

public class Hotplate extends PlaceToCook{
    @Inject
    Hotplate() {
        super("электрическая плитка");
    }

    @Override
    public void fire() {
        System.out.println(getName() + " разогревается");
        this.setHeat(true);
    }

    @Override
    public void putOut() {
        System.out.println(getName() + " остывает");
        this.setHeat(false);
    }
}
