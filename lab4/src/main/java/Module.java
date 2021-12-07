import Air.Air;
import Air.AirFactory;
import Cooking.Ingredients.Ingredient;
import Cooking.Ingredients.IngredientFactory;
import Cooking.RecipeFactory;
import Cooking.RecipeFactoryImpl;
import Human.FaceElement;
import Human.FaceFactory;
import Human.Heroes.ShpuntikPlace;
import Human.Heroes.VintikPlace;
import Human.Heroes.ZnaikaPlace;
import Human.Human;
import Physical.*;
import Physical.Position.RelativePos;
import PlaceMap.Door.Door;
import PlaceMap.Door.DoorFactory;
import PlaceMap.Place.PlaceFactory;
import PlaceMap.PlaceMap;
import PlaceMap.PlaceMapProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Module extends AbstractModule {

    @Override
    protected void configure(){
        bind(new TypeLiteral<List<Door>>(){}).to(new TypeLiteral<LinkedList<Door>>(){});

        bind(new TypeLiteral<List<Human>>(){}).to(new TypeLiteral<LinkedList<Human>>(){});

        bind(new TypeLiteral<Map<PhysicalObject, RelativePos>>() {})
                .to(new TypeLiteral<HashMap<PhysicalObject, RelativePos>>() {});

        bind(new TypeLiteral<List<PhysicalObject>>() {})
                .to(new TypeLiteral<LinkedList<PhysicalObject>>() {});

        bind(new TypeLiteral<List<PlaceElement>>() {})
                .to(new TypeLiteral<LinkedList<PlaceElement>>() {});
        bind(new TypeLiteral<List<Wearable>>() {})
                .to(new TypeLiteral<LinkedList<Wearable>>() {});
        bind(new TypeLiteral<Map<Pair<PhysicalObject, PhysicalObject>, RelativePos>>() {})
                .to(new TypeLiteral<HashMap<Pair<PhysicalObject, PhysicalObject>, RelativePos>>() {});
        bind(new TypeLiteral<List<Ingredient>>() {})
                .to(new TypeLiteral<LinkedList<Ingredient>>() {});
        bind(new TypeLiteral<Map<PhysicalObject, Air>>() {})
                .to(new TypeLiteral<HashMap<PhysicalObject, Air>>() {});

        bind(PhysicalFactory.class).to(PhysicalFactoryImpl.class);

        install(new FactoryModuleBuilder().build(PlaceFactory.class));
        install(new FactoryModuleBuilder().build(DoorFactory.class));
        install(new FactoryModuleBuilder().build(FaceFactory.class));
        install(new FactoryModuleBuilder().build(IngredientFactory.class));
        install(new FactoryModuleBuilder().build(AirFactory.class));

        bind(PlaceMap.class).toProvider(PlaceMapProvider.class).in(Singleton.class);
        bind(RecipeFactory.class).to(RecipeFactoryImpl.class);

        bind(String.class).annotatedWith(VintikPlace.class).toInstance("кухня");
        bind(String.class).annotatedWith(ShpuntikPlace.class).toInstance("кухня");
        bind(String.class).annotatedWith(ZnaikaPlace.class).toInstance("кухня");
    }

    @Provides
    List<FaceElement> provideFace(FaceFactory faceFactory){
        List<FaceElement> res = new LinkedList<>();
        res.add(faceFactory.createFaceElement("лоб"));
        res.add(faceFactory.createFaceElement("подбородок"));
        res.add(faceFactory.createFaceElement("щеки"));
        res.add(faceFactory.createUnprotectedFaceElement("нос"));
        res.add(faceFactory.createUnprotectedFaceElement("глаза"));
        res.add(faceFactory.createUnprotectedFaceElement("рот"));
        return res;
    }
}
