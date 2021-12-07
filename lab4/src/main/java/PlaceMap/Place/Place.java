package PlaceMap.Place;

import Physical.PhysicalObject;
import Physical.PlaceElement;
import PlaceMap.Door.Door;
import Human.Human;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import java.util.Collections;
import java.util.List;

public class Place {
    private final String name;
    private final List<Door> doors;
    private final List<Human> humans;
    private final List<PhysicalObject> items;
    private final List<PlaceElement> elements;

    @AssistedInject
    Place(List<Door> doors, List<Human> humans, List<PhysicalObject> items, List<PlaceElement> elements, @Assisted String name){
        this.doors = doors;
        this.humans = humans;
        this.name = name;
        this.items = items;
        this.elements = elements;
    }

    public void addDoor(Door door){
        doors.add(door);
    }

    public void addPlaceElement(PlaceElement element) {
        elements.add(element);
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public void removeHuman(Human human) {
        humans.remove(human);
    }

    public void addItem(PhysicalObject item) {
        items.add(item);
    }

    public void removeItem(PhysicalObject item) {
        items.remove(item);
    }

    public List<Human> getHumans() {
        return Collections.unmodifiableList(humans);
    }

    public List<Door> getDoors() {
        return Collections.unmodifiableList(doors);
    }

    public String getName() {
        return name;
    }

    public List<PhysicalObject> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<PlaceElement> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
