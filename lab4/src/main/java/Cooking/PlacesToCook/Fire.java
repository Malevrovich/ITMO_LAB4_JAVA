package Cooking.PlacesToCook;

import Air.AirEngine;
import Cooking.Exceptions.NoOxygenNearFurnace;
import com.google.inject.Inject;

class Fire{
        private final AirEngine airEngine;

        @Inject
        Fire(AirEngine airEngine){
            this.airEngine = airEngine;
        }

        public void fire(Furnace furnace) throws NoOxygenNearFurnace {
            for(int i = 0; i < 2; i++){
                if(airEngine.getAirNear(furnace).isFresh()){
                    airEngine.reduceOxygenNear(furnace);
                    airEngine.heatAirNear(furnace);
                } else{
                    throw new NoOxygenNearFurnace("Рядом с " + furnace.getName() + " нет кислорода");
                }
            }
        }
    }