package Human;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class FaceElement {
    private final String name;

    @AssistedInject
    public FaceElement(@Assisted String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
