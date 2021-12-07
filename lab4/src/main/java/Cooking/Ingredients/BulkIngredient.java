package Cooking.Ingredients;

import Cooking.Cookware.Pot;
import Human.Human;
import Human.FaceElement;
import Human.UnprotectedFaceElement;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class BulkIngredient extends Ingredient implements Dispersable{

    @AssistedInject
    protected BulkIngredient(@Assisted String name) {
        super(name);
    }

    public void gatherIn(Pot pot){
        pot.addIngredient(this);
    }

    public PackOfIngredient gatherInPack(){
        return new PackOfIngredient(this);
    }

    @Override
    public void disperse() {
        System.out.println(getName() + " рассеивается в воздухе");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " летает повсюду");
    }

    @Override
    public void attack(Human h) {
        System.out.println(getName() + " мешвет " + h.getName() + ": ");
        for(FaceElement faceElement: h.getFaceElements()){
            if(faceElement instanceof UnprotectedFaceElement){
                ((UnprotectedFaceElement) faceElement).penetrate(this);
            }
        }
        System.out.println();
    }
}
