package Cooking.Ingredients.Liquid;

public class WaterTap implements LiquidTap{
    @Override
    public Water createLiquid() {
        return new Water();
    }
}
