package supermarket;

public class Manager {
    private final String name;

    public Manager(String name) {
        this.name = name;
    }

    public void addCashierToSupermarket(Cashier cashier, Supermarket supermarket) {
        supermarket.addCashier(cashier);
    }

    public void addGatemanToSupermarket(Gateman gateman, Supermarket supermarket){
        supermarket.addGateMan(gateman);
    }

    public void addCleanerToSupermarket(Cleaner cleaner, Supermarket supermarket){
        supermarket.addCleaner(cleaner);
    }

    public void addProductToSupermarketInventory(Product product, int quantity, Supermarket supermarket) {
        supermarket.addProduct(product, quantity);
    }
}
