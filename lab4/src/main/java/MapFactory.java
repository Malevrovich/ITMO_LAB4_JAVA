import com.google.inject.Inject;

public class MapFactory{
    private final DoorFactory doorFactory;
    private final PlaceFactory placeFactory;

    @Inject
    public MapFactory(DoorFactory doorFactory, PlaceFactory placeFactory) {
        this.doorFactory = doorFactory;
        this.placeFactory = placeFactory;
    }

    public Map createMap() {
        Place kitchen = placeFactory.createPlace("кухня");
        Place workshop = placeFactory.createPlace("мастерская");
        Place outdoor = placeFactory.createPlace("двор");
        Place corridor = placeFactory.createPlace("коридор");

        Door k_c = doorFactory.createDoor(kitchen, corridor);
        Door c_o = doorFactory.createDoor(corridor, outdoor);
        Door o_w = doorFactory.createDoor(outdoor, workshop);

        return new Map(kitchen, workshop, outdoor, corridor);
    }
}
