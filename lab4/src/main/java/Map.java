import com.google.inject.Singleton;

@Singleton
public class Map {
    private final Place kitchen;
    private final Place workshop;
    private final Place outdoor;
    private final Place corridor;

    protected Map(Place kitchen, Place workshop, Place outdoor, Place corridor) {
        this.kitchen = kitchen;
        this.workshop = workshop;
        this.outdoor = outdoor;
        this.corridor = corridor;
    }

    public Place getByName(String name){
        switch (name) {
            case "кухня":
                return kitchen;
            case "мастерская":
                return workshop;
            case "коридор":
                return corridor;
            case "двор":
                return outdoor;
            default:
                return null;
        }
    }

    public Place getKitchen() {
        return kitchen;
    }

    public Place getWorkshop() {
        return workshop;
    }

    public Place getOutdoor() {
        return outdoor;
    }

    public Place getCorridor() {
        return corridor;
    }
}
