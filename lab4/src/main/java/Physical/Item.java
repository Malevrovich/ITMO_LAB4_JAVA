package Physical;

import Physical.Properties.Leanable;

public class Item extends PhysicalObject implements Leanable {
    private final boolean isHeavy;

    protected Item(String name, boolean isHeavy) {
        super(name);
        this.isHeavy = isHeavy;
    }

    @Override
    public void makeLeaned(PhysicalObject dst) {
        if(!isHeavy) {
            System.out.println(dst.getName() + " пытается опереться на " + this.getName()
                    + ", но " + this.getName() + " недостаточно тяжелый");
        } else{
            System.out.println(dst.getName() + " опирается на " + this.getName());
        }
    }

    public boolean isHeavy() {
        return isHeavy;
    }
}
