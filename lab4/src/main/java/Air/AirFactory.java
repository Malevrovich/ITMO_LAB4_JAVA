package Air;

import com.google.inject.assistedinject.Assisted;

public interface AirFactory {
    Air createAir(@Assisted("fresh") boolean isFresh,@Assisted("hot") boolean isHot);
}
