public class Human {
    private Place currentPlace;
    private final String name;

    Human(Place currentPlace, String name){
        this.currentPlace = currentPlace;
        this.name = name;

        currentPlace.addHuman(this);
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getName() {
        return name;
    }
}
