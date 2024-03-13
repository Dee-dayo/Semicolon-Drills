package dependencyInjectionConstructor;

public class PapaDayo {
    private BreastfeedBehaviour breastfeed;
    private DrinkBehaviour drink;

    public PapaDayo(BreastfeedBehaviour breastfeed, DrinkBehaviour drink) {
        this.breastfeed = breastfeed;
        this.drink = drink;
    }

    public void drink(){
        this.drink.drink();
    }

}
