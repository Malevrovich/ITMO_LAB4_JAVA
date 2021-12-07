package Physical.Position;

import Physical.PhysicalObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import javafx.util.Pair;

import java.util.Map;

@Singleton
public class PositionEngine {
    private final Map<Pair<PhysicalObject, PhysicalObject>, RelativePos> pos;

    @Inject
    public PositionEngine(Map<Pair<PhysicalObject, PhysicalObject>, RelativePos> pos) {
        this.pos = pos;
    }

    public RelativePos getPosition(PhysicalObject lhs, PhysicalObject rhs){
        return pos.getOrDefault(new Pair<>(lhs, rhs), RelativePos.UNKNOWN);
    }

    public void setPosition(PhysicalObject lhs, PhysicalObject rhs, RelativePos relativePos){
        System.out.println(lhs.getName() + " оказывается " + relativePos.getPhrase() + " " + rhs.getName());
        pos.put(new Pair<>(lhs, rhs), relativePos);
        pos.put(new Pair<>(rhs, lhs), relativePos.getOpposite());
    }
}
