import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Screw extends Human{
    @Inject
    Screw(Map map, @ScrewPlace String bornPlace) {
        super(map.getByName(bornPlace), "Винтик");
    }
}
