package Air;

import Physical.PhysicalObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Map;

@Singleton
public class AirEngine {
    private final Map<PhysicalObject, Air> airMap;
    private final AirFactory airFactory;

    private static final boolean ZERO_GRAVITY = true;

    @Inject
    public AirEngine(Map<PhysicalObject, Air> airMap, AirFactory airFactory) {
        this.airMap = airMap;
        this.airFactory = airFactory;
    }

    private void getUp(Air air){
        air.setFresh(true);
        air.setHot(false);
    }

    public Air getAirNear(PhysicalObject target){
        return airMap.getOrDefault(target, airFactory.createAir(true, false));
    }

    public void heatAirNear(PhysicalObject target){
        System.out.println("Воздух возле " + target.getName() + " нагревается");
        if(airMap.get(target) != null){
            airMap.get(target).setHot(true);
        } else {
            airMap.put(target, airFactory.createAir(true, false));
        }

        if(!ZERO_GRAVITY){
            getUp(airMap.get(target));
        } else{
            System.out.println("Воздух возле " + target.getName() + " не поднимается");
        }
    }

    public void reduceOxygenNear(PhysicalObject target){
        System.out.println("Кислород возле " + target.getName() + " кончается");
        if(airMap.get(target) != null){
            airMap.get(target).setFresh(false);
        } else{
            airMap.put(target, airFactory.createAir(false, false));
        }
    }
}
