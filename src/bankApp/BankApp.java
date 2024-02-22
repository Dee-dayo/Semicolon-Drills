package bankApp;

import java.util.Scanner;

public class BankApp {
    private static Bank bank;


    public static void main(String[] args) {
        bank = new Bank("UBA");
        Scanner input = new Scanner(System.in);
        int answer;

        do {
            System.out.printf("Welcome to bank %s\n\n", bank.getName());
            System.out.println("Press 1 to register \nPress 2 to Deposit: \n" +
                    "Press 3 to Withdraw \nPress 4 to transfer: \nPress 5 to Check Balance\n" +
                    "Press 6 to Find Account\nPress 7 to RemoveAccount\nPress 8 to exit");
            answer = input.nextInt();

            switch (answer) {
                case 1:
                    System.out.print("\n\nREGISTER ACCOUNT\nEnter first name: ");
                    String firstName = input.next();
                    System.out.print("Enter surname: ");
                    input.nextLine();
                    String lastName = input.nextLine();
                    System.out.print("Enter desired pin: ");
                    String pin = input.nextLine();
                    bank.registerCustomer(firstName, lastName, pin);
                    System.out.println("\n<<Account registered successfully>>");
                    System.out.printf("Dear %s, Your account number is: %d\n\n", bank.getCustomerName(), bank.getCustomerAccNo());
                    break;

                case 2:
                    try {
                        System.out.print("\nDEPOSIT\nEnter Account number: ");
                        int accNo = input.nextInt();
                        System.out.print("Enter deposit amount: ");
                        int depositAmount = input.nextInt();
                        bank.deposit(accNo, depositAmount);
                        System.out.println("\n<<Amount deposited successfully>>\n");
                    } catch (NoAccountFound message) {
                        System.out.println("Account number not found\n");
                    } catch (InvalidAmountException message) {
                        System.out.println("You cant deposit negative numbers\n");
                    }
                    break;

                case 3:
                    System.out.println("\nWITHDRAW\nEnter Account number: ");
                    int accNo = input.nextInt();
                    System.out.println("Enter withdraw amount");


                case 8:
                    System.out.println("Thank you for banking with us");
                    break;

                default:
                    System.out.println("Invalid input");
            }
        } while (answer != 8);

    }
}

