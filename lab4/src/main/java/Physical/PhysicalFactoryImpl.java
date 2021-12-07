package Physical;

public class PhysicalFactoryImpl implements PhysicalFactory{
    @Override
    public PlaceElement createPlaceElement(String name) {
        return new PlaceElement(name);
    }

    @Override
    public Item createItem(String name, boolean isHeavy) {
        return new Item(name, isHeavy);
    }

    @Override
    public Wearable createWearable(String name) {
        return new Wearable(name);
    }
}
