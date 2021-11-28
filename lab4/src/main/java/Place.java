import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import java.util.Collections;
import java.util.List;

public class Place {
    private final String name;
    private final List<Door> doors;
    private final List<Human> humans;

    @AssistedInject
    Place(List<Door> doors, List<Human> humans, @Assisted String name){
        this.doors = doors;
        this.humans = humans;
        this.name = name;
    }

    public void addDoor(Door door){
        doors.add(door);
    }

    public void addHuman(Human human){
        humans.add(human);
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
}
