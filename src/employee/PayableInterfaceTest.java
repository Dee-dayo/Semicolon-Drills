package employee;

public class PayableInterfaceTest {
    public static void main(String[] args) {
        Payable[] payables = new Payable[]{
                new Invoice("01234", "seat", 2, 375.00),
                new Invoice("56789", "tire", 4, 79.95),
                new SalariedEmployee("John", "Smith", "111-11", 800.00),
                new SalariedEmployee("Lisa", "Barnes", "222-22", 1_200.00)
        };

        System.out.println("Invoices and employees processed polymorphically");

        for (Payable currentPayable : payables){
            System.out.printf("%n%s %npayment due: $%,.2f%n", currentPayable.toString(), currentPayable.getPaymentAmount());
        }
    }

}
