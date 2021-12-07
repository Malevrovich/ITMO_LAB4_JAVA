package Human.Heroes;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@BindingAnnotation
@Target({PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VintikPlace {
}
