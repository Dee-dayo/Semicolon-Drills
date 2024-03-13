package dependencyInjection;

public class LekkiGuy implements Boyfriend {
    @Override
    public void spend() {
        System.out.println("Let's go to Maldives");
    }

    @Override
    public void cook() {
        System.out.println("The cook would make the meal, go to bed");
    }

    @Override
    public void clean() {
        System.out.println("Let's get an extra cleaner please");
    }
}
