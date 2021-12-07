package PlaceMap.Door;

import Human.Human;
import Physical.PhysicalObject;
import Physical.Position.RelativePos;
import PlaceMap.Place.Place;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import java.util.Map;

public class DoorWithLock extends Door{

    boolean isLocked = true;

    @Override
    public Door open() {
        if(!isLocked){
            isOpen = true;
        } else{
            System.out.println("Дверь закрыта на замок");
        }
        return this;
    }

    public void lock() {
        System.out.println("Замок двери закрывается");
        isLocked = true;
    }

    private void unlock() {
        System.out.println("Замок двери открывается");
        isLocked = false;
    }

    public void pullTheHandle(Human h){
        if(h.isLeaned()){
            System.out.println(h.getName() + " использует руку двери");
            unlock();
        } else{
            System.out.println(h.getName() + " пытается использовать ручку двери, но ему не хватает сцепления");
        }
    }

    @AssistedInject
    protected DoorWithLock(@Assisted("lhs") Place lhs, @Assisted("rhs") Place rhs) {
        super(lhs, rhs);
    }


}
