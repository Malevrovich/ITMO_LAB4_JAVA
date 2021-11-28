import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module());
        Screw screw = injector.getInstance(Screw.class);
        Screw screw1 = injector.getInstance(Screw.class);
        Map map = injector.getInstance(Map.class);

        System.out.println(map.getKitchen().getHumans());
        System.out.println(screw == screw1);
    }
}
