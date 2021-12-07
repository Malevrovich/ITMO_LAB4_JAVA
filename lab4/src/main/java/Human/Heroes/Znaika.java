package Human.Heroes;

import Human.FaceElement;
import Human.Human;
import Physical.Wearable;
import PlaceMap.PlaceMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class Znaika extends Human {
    @Inject
    Znaika(List<Wearable> clothes, PlaceMap placeMap, List<FaceElement> face, @ZnaikaPlace String bornPlace) {
        super(placeMap.getByName(bornPlace), "Знайка", clothes, face);
    }
}
