package dependencyInjection;

public class MushinGuy implements Boyfriend{

    @Override
    public void spend() {
        System.out.println("Let's go to Iya basira shop");
    }

    @Override
    public void cook() {
        System.out.println("Foodstuff dy kitchen, go cook");
    }

    @Override
    public void clean() {
        System.out.println("Let's go clean together");
    }
}
