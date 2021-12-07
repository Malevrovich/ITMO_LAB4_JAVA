package PlaceMap.Door;

import PlaceMap.Place.Place;
import com.google.inject.assistedinject.Assisted;

public interface DoorFactory {
    Door createDoor(@Assisted("lhs") Place lhs,@Assisted("rhs") Place rhs);
    DoorWithLock createDoorWithLock(@Assisted("lhs") Place lhs,@Assisted("rhs") Place rhs);
}
