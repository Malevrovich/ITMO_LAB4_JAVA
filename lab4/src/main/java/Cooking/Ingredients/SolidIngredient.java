package Cooking.Ingredients;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class SolidIngredient extends Ingredient{
    @AssistedInject
    protected SolidIngredient(@Assisted String name) {
        super(name);
    }
}
