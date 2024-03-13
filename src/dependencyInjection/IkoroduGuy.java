package dependencyInjection;

public class IkoroduGuy implements Boyfriend{

    @Override
    public void spend() {
        System.out.println("Alaye money no dy today jare");
    }

    @Override
    public void cook() {
        System.out.println("Na 001 we dy do today oo");
    }

    @Override
    public void clean() {
        System.out.println("Oga go sweep the floor jare");
    }
}
