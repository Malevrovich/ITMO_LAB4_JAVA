package Cooking.Ingredients;

import Physical.PhysicalObject;

public abstract class Ingredient extends PhysicalObject implements Comparable<Ingredient>{
    private IngredientStatus status;

    protected Ingredient(String name) {
        super(name);
        status = IngredientStatus.RAW;
    }

    public void setStatus(IngredientStatus status) {
        this.status = status;
        System.out.println(getName() + " становится " + status.getPhrase());
    }

    @Override
    public int compareTo(Ingredient ingredient){
        return getName().compareTo(ingredient.getName());
    }

    public IngredientStatus getStatus() {
        return status;
    }
}
