package supermarketTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarket.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketTest {
    private Supermarket jendolSupermart;
    private Manager manager;

    @BeforeEach
    public void setUp(){
        manager = new Manager("Moh");
        jendolSupermart = new Supermarket(manager);
    }

    @Test
    public void supermarketHasOneManger(){
        assertEquals(1, jendolSupermart.noOfManger());
    }

    @Test
    public void ManagerCanAddCashier(){
        Cashier cashier1 = new Cashier("Jumoke");
        manager.addCashierToSupermarket(cashier1, jendolSupermart);

        assertEquals(1, jendolSupermart.getNoOfCashier());
        assertEquals(1, jendolSupermart.getNumberOfEmployees());
    }

    @Test
    public void ManagerCanAddGateman(){
        Gateman gateman = new Gateman("Beejay");
        manager.addGatemanToSupermarket(gateman, jendolSupermart);
        assertEquals(1, jendolSupermart.getNumberOfEmployees());
        assertEquals(1, jendolSupermart.getNoOfGateman());
    }

    @Test
    public void ManagerCanAddCleaner(){
        Cleaner cleaner = new Cleaner("Izu");
        manager.addCleanerToSupermarket(cleaner, jendolSupermart);
        assertEquals(1, jendolSupermart.getNumberOfEmployees());
        assertEquals(1, jendolSupermart.getNoOfCleaners());
    }

    @Test
    public void supermarketHasFiveEmployees(){
        manager.addCashierToSupermarket(new Cashier("Jumoke"), jendolSupermart);
        manager.addCashierToSupermarket(new Cashier("Blessing"), jendolSupermart);
        manager.addCashierToSupermarket(new Cashier("Victoria"), jendolSupermart);
        manager.addCleanerToSupermarket(new Cleaner("Izu"), jendolSupermart);
        manager.addGatemanToSupermarket(new Gateman("Beejay"), jendolSupermart);

        assertEquals(5, jendolSupermart.getNumberOfEmployees());
    }

//    @Test
//    public void supermarketHasInventoryofProducts(){
//        assertEquals(new Inventory(), jendolSupermart.getInventory());
//    }


    @Test
    public void productsCanBeAddedToInventory(){
       Cashier cashier = new Cashier("Jumoke");
       manager.addCashierToSupermarket(cashier, jendolSupermart);

       Bread bread = new Bread("Jendol bread", 10);
       manager.addProductToSupermarketInventory(bread, 10, jendolSupermart);

       Inventory jendolInventory = jendolSupermart.getInventory();
       Product test = jendolInventory.getProductByName("bread");


        System.out.println(test.getName());

//       jendolInventory.addProduct(bread, 10);
       assertEquals(10, jendolInventory.noOfProducts());
    }
}
