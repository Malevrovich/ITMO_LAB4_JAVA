package Physical;

import Physical.Position.PositionEngine;
import Physical.Position.RelativePos;
import Physical.Properties.Leanable;
import Physical.Properties.Nailable;

public class PlaceElement extends PhysicalObject implements Leanable, Nailable {

    protected PlaceElement(String name) {
        super(name);
    }

    @Override
    public void makeLeaned(PhysicalObject dst) {
        System.out.println(dst.getName() + " опирается на " + getName());
        dst.setLeaned(true);
    }

    @Override
    public void makeNailed(PhysicalObject dst, PositionEngine engine) {
        engine.setPosition(this, dst, RelativePos.NAILED);
    }
}
