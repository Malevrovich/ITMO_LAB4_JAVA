package Cooking.Ingredients;

import Human.Human;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class PackOfIngredient extends Ingredient{
    private final BulkIngredient content;

    @AssistedInject
    public PackOfIngredient(@Assisted BulkIngredient content) {
        super("упаковка " + content.getName());
        this.content = content;
    }

    public BulkIngredient unpack(Human human){
        System.out.println(human.getName() + " открывает " + getName());
        content.disperse();
        content.fly();
        for(Human h: human.getCurrentPlace().getHumans()){
            content.attack(h);
        }
        return content;
    }

    public void close(Human human){
        System.out.println(human.getName() + " закрывает " + getName());
    }
}
