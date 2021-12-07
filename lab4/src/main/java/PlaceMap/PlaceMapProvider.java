package PlaceMap;

import Physical.PhysicalFactory;
import PlaceMap.Door.Door;
import PlaceMap.Door.DoorFactory;
import PlaceMap.Place.Place;
import PlaceMap.Place.PlaceFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class PlaceMapProvider implements Provider<PlaceMap> {
    private final DoorFactory doorFactory;
    private final PlaceFactory placeFactory;
    private final PhysicalFactory physicalFactory;

    @Inject
    public PlaceMapProvider(DoorFactory doorFactory, PlaceFactory placeFactory, PhysicalFactory physicalFactory) {
        this.doorFactory = doorFactory;
        this.placeFactory = placeFactory;
        this.physicalFactory = physicalFactory;
    }

    private void makeRoom(Place p){
        p.addPlaceElement(physicalFactory.createPlaceElement("пол"));
        for(int i = 0; i < 4; i++) {
            p.addPlaceElement(physicalFactory.createPlaceElement("стена"));
        }
        p.addPlaceElement(physicalFactory.createPlaceElement("потолок"));
    }

    @Override
    public PlaceMap get() {
        Place kitchen = placeFactory.createPlace("кухня");
        makeRoom(kitchen);

        Place workshop = placeFactory.createPlace("мастерская");
        makeRoom(workshop);

        Place outdoor = placeFactory.createPlace("двор");

        Place corridor = placeFactory.createPlace("коридор");
        makeRoom(corridor);

        doorFactory.createDoor(kitchen, corridor);
        doorFactory.createDoorWithLock(corridor, outdoor);
        doorFactory.createDoor(outdoor, workshop);

        kitchen.addItem(physicalFactory.createItem("стол", true));
        corridor.addItem(physicalFactory.createItem("шкаф", true));
        corridor.addItem(physicalFactory.createItem("стул", false));
        corridor.addItem(physicalFactory.createItem("какой-либо предмет", true));

        outdoor.addItem(physicalFactory.createItem("беседка", true));
        outdoor.addItem(physicalFactory.createItem("забор", true));

        return new PlaceMap(kitchen, workshop, outdoor, corridor);
    }
}
