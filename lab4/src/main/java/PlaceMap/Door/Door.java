package PlaceMap.Door;

import Human.Human;
import Physical.Properties.Leanable;
import Physical.Position.RelativePos;
import PlaceMap.Place.Place;
import Physical.PhysicalObject;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import java.util.Map;

public class Door extends PhysicalObject implements Leanable {
    private final Place lhs;
    private final Place rhs;
    protected boolean isOpen = false;

    @AssistedInject
    protected Door(@Assisted("lhs") Place lhs,@Assisted("rhs") Place rhs){
        super("дверь");
        this.lhs = lhs;
        this.rhs = rhs;

        lhs.addDoor(this);
        rhs.addDoor(this);
    }

    public Door open(){
        System.out.println("Дверь открывается");
        isOpen = true;
        return this;
    }

    public Door close(){
        System.out.println("Дверь закрывается");
        isOpen = false;
        return this;
    }

    public boolean go(Human human){
        if (isOpen) {
            human.getCurrentPlace().removeHuman(human);
            if (human.getCurrentPlace().getName().equals(getLhs())) {
                human.setCurrentPlace(rhs);
            } else if (human.getCurrentPlace().getName().equals(getRhs())) {
                human.setCurrentPlace(lhs);
            } else {
                System.err.println("ERROR");
                return false;
            }
            human.getCurrentPlace().addHuman(human);
            return true;
        } else{
            return false;
        }
    }

    public void forceBy(PhysicalObject src, boolean isReturnable) {
        System.out.println(src.getName() + " толкает дверь");


        open();
        if(isOpen){
            isReturnable = false;
        }

        if(isReturnable){
            src.forceBy(this, false);
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getRhs() {
        return rhs.getName();
    }

    public String getLhs() {
        return lhs.getName();
    }

    @Override
    public void makeLeaned(PhysicalObject dst) {
        if(!isOpen){
            System.out.println(dst.getName() + " опирается на " + getName());
            dst.setLeaned(true);
        }
    }
}
