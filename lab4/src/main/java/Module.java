import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.util.ArrayList;
import java.util.List;

public class Module extends AbstractModule {

    @Override
    protected void configure(){
        bind(new TypeLiteral<List<Door>>(){}).to(new TypeLiteral<ArrayList<Door>>(){});
        bind(new TypeLiteral<List<Human>>(){}).to(new TypeLiteral<ArrayList<Human>>(){});

        install(new FactoryModuleBuilder().build(PlaceFactory.class));

        bind(DoorFactory.class).to(DoorFactoryImpl.class);
        bind(String.class).annotatedWith(ScrewPlace.class).toInstance("кухня");
    }

    @Provides @Singleton
    Map provideMap(MapFactory mapFactory){
        return mapFactory.createMap();
    }
}
