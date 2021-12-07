package Torpedo;

import Physical.PhysicalObject;
import Physical.Position.RelativePos;
import com.google.inject.Inject;

import java.util.Map;

public class Torpedo extends PhysicalObject implements TorpedoLike{
    protected Torpedo() {
        super("торпеда");
    }

    @Override
    public void fire(TorpedoVisitor torpedoVisitor) {
        torpedoVisitor.fireTorpedo(this);
    }
}
