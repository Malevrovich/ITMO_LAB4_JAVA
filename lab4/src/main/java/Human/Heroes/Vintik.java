package Human.Heroes;

import Human.FaceElement;
import Human.Human;
import Physical.Wearable;
import PlaceMap.PlaceMap;
import Torpedo.TorpedoLike;
import Torpedo.TorpedoVisitor;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class Vintik extends Human implements TorpedoLike {
    @Inject
    Vintik(PlaceMap placeMap, List<Wearable> clothes, List<FaceElement> face, @VintikPlace String bornPlace) {
        super(placeMap.getByName(bornPlace), "Винтик", clothes, face);
    }

    @Override
    public void fire(TorpedoVisitor torpedoVisitor) {
        torpedoVisitor.fireScrew(this);
    }
}
