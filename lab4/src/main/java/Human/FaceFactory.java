package Human;

import java.util.List;

public interface FaceFactory {
    FaceElement createFaceElement(String name);
    UnprotectedFaceElement createUnprotectedFaceElement(String name);
}
