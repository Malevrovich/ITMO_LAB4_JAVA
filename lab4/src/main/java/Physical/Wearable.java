package Physical;

import Human.Human;

public class Wearable extends PhysicalObject {

    protected Wearable(String name) {
        super(name);
    }

    public void takeOn(Human human){
        human.addWearable(this);
    }
    public void takeOff(Human human){
        human.removeWearable(this);
    }
}
