package Air;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class Air {
    private boolean isHot;
    private boolean isFresh;

    @AssistedInject
    public Air(@Assisted("hot") boolean isHot,@Assisted("fresh") boolean isFresh) {
        this.isHot = isHot;
        this.isFresh = isFresh;
    }

    protected void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    protected void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public boolean isHot() {
        return isHot;
    }
}
