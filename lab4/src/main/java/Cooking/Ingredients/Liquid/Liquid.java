package Cooking.Ingredients.Liquid;

import Cooking.Cookware.Cookware;
import Cooking.Cookware.Pot;
import Cooking.Ingredients.Dispersable;
import Cooking.Ingredients.Ingredient;
import Human.Human;
import Human.FaceElement;
import Human.UnprotectedFaceElement;
import Physical.PhysicalObject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class Liquid extends Ingredient implements Dispersable {
    @AssistedInject
    protected Liquid(@Assisted String name) {
        super(name);
    }

    @Override
    public void forceBy(PhysicalObject src, boolean isReturnable) {
        if(src instanceof Cookware){
            System.out.println(getName() + " отскакивает от " + src.getName());

            if(isReturnable){
                src.forceBy(this, false);
            }
        } else {
            super.forceBy(src, isReturnable);
        }
    }

    public Pot gatherIn(Pot pot) {
        pot.fill(this);
        return pot;
    }

    @Override
    public void disperse() {
        System.out.println(getName() + " собирается в множество мелких и крупных шариков");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " летает повсюду");
    }

    @Override
    public void attack(Human h) {
        System.out.println(getName() + " мешает " + h.getName() + ": ");
        for(FaceElement faceElement: h.getFaceElements()){
            if(faceElement instanceof UnprotectedFaceElement){
                ((UnprotectedFaceElement) faceElement).penetrate(this);
            }
        }
        System.out.println();
    }
}
