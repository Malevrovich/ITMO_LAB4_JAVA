package Human;

import Cooking.Recipe;
import Physical.PhysicalObject;
import Physical.Wearable;
import PlaceMap.Place.Place;
import com.google.inject.Inject;

import java.util.Collections;
import java.util.List;

public class Human extends PhysicalObject {
    private Place currentPlace;
    private final List<Wearable> clothes;
    private final List<FaceElement> faceElements;

    @Inject
    public Human(Place currentPlace, String name, List<Wearable> clothes, List<FaceElement> faceElements){
        super(name);
        this.currentPlace = currentPlace;
        this.clothes = clothes;
        this.faceElements = faceElements;

        currentPlace.addHuman(this);
    }

    public void talkTo(Human human){
        System.out.println(getName() + " говорит " + human.getName());
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Place currentPlace) {
        System.out.println(getName() + " покидает " + this.currentPlace.getName());
        System.out.println(getName() + " оказывается в " + currentPlace.getName());
        this.currentPlace = currentPlace;
    }

    public List<Wearable> getClothes() {
        return Collections.unmodifiableList(clothes);
    }

    public void addWearable(Wearable item){
        System.out.println(getName() + " надевает " + item.getName());
        clothes.add(item);
    }

    public void removeWearable(Wearable item){
        System.out.println(getName() + " снимает " + item.getName());
        clothes.remove(item);
    }

    public List<FaceElement> getFaceElements() {
        return faceElements;
    }
}
