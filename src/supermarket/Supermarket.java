package supermarket;
import java.util.ArrayList;

public class Supermarket {
    private final Manager manager;
    private final ArrayList<Cashier> cashiers;
    private final ArrayList<Gateman> gateMen;
    private final ArrayList<Cleaner> cleaners;
    private final Inventory inventory;

    public Supermarket(Manager managerName){
        this.manager = managerName;
        cashiers = new ArrayList<>();
        gateMen = new ArrayList<>();
        cleaners = new ArrayList<>();
        inventory = new Inventory();
    }

    public int noOfManger() {
        return 1;
    }


    public int getNumberOfEmployees() {
        return cashiers.size() + gateMen.size() + cleaners.size();
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    public void addGateMan(Gateman gateman) {
        gateMen.add(gateman);
    }

    public void addCleaner(Cleaner cleaner) {
        cleaners.add(cleaner);
    }

    public int getNoOfCashier() {
        return cashiers.size();
    }

    public int getNoOfGateman() {
        return gateMen.size();
    }

    public int getNoOfCleaners() {
        return cleaners.size();
    }
    public Inventory getInventory(){
        return inventory;
    }

    public void addProduct(Product product, int quantity) {
        inventory.addProduct(product, quantity);
    }
}
