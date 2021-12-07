package Human;

import Physical.PhysicalObject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class UnprotectedFaceElement extends FaceElement{
    @AssistedInject
    public UnprotectedFaceElement(@Assisted String name) {
        super(name);
    }

    public void penetrate(PhysicalObject obj){
        System.out.println(obj.getName() + " лезет в " + this.getName());
    }
}
