package Torpedo;

import Human.Heroes.Vintik;

public class TorpedoVisitor {
    public void fireTorpedo(Torpedo t){
        System.out.println("Торпеда вылетает из торпедного аппарата");
    }
    public void fireScrew(Vintik vintik){
        System.out.println("Винтик вылетает, словно торпеда");
    }
}
