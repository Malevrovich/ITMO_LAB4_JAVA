package Physical;

public interface PhysicalFactory {
    PlaceElement createPlaceElement(String name);
    Item createItem(String name, boolean isHeavy);
    Wearable createWearable(String name);
}
