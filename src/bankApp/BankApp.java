package bankApp;

import java.util.Scanner;

public class BankApp {
    private static Bank ubaBank = new Bank("UBA Bank");

    public static void main(String[] args) {
        mainApp();
    }

    public static void mainApp(){
        goToDisplayPage();
    }

    private static void goToDisplayPage() {
        print("""
                Welcome to UBA Bank App
                1-> Register Account
                2-> Deposit
                3-> Withdraw
                4-> Transfer
                5-> Check Balance
                6-> Delete Account
                7-> Exit App
                """);

        String userInput = input("");

        switch(userInput.charAt(0)) {
            case '1' -> registerAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
//            case '5' -> checkBalance();
//            case '6' -> removeAcc();
            case '7' -> exit();
            default -> goToDisplayPage();
        }
    }

    private static void transfer() {
        print("\nTRANSFER MONEY\n");
        String from = input("Enter sender account number: ");
        String to = input("Enter receiver number: ");
        String amount = input("Enter amount to transfer: ");
        String pin = input("Enter your pin: ");
        try {
            ubaBank.transfer(Integer.parseInt(from), Integer.parseInt(to), Integer.parseInt(amount),pin);
            print("***Amount transferred successfully***\n");
        } catch (Exception message){
            print(message.getMessage());
        }
        finally {
            print("\n");
            goToDisplayPage();
        }
    }

    private static void withdraw() {
        print("\nWITHDRAW MONEY\n");
        String accNo = input("Enter Account number: ");
        String amount = input("Enter amount to withdraw: ");
        String pin = input("Enter pin: ");
        try {
            ubaBank.withdraw(Integer.parseInt(accNo), Integer.parseInt(amount), pin);
            print("***Amount withdrawn Successfully***\n");
        } catch (Exception message){
            print(message.getMessage());
        }
        finally {
            print("\n");
            goToDisplayPage();
        }
    }

    private static void deposit() {
        print("\nDEPOSIT MONEY\n");
        String accNo = input("Enter Account number: ");
        String amount = input("Enter deposit amount: ");
        try{
            ubaBank.deposit(Integer.parseInt(accNo), Integer.parseInt(amount));
            print("***Amount deposited Successfully***\n");
        } catch (Exception message){
            print(message.getMessage());
        }
        finally {
            print("\n");
            goToDisplayPage();
        }

    }

    private static void registerAccount() {
        print("\nREGISTER A NEW ACCOUNT\n");
        String firstName = input("Enter first name: ");
        String lastName = input("Enter surname: ");
        String pin = input("Enter desired pin: ");
        Account account = ubaBank.registerCustomer(firstName, lastName, pin);
        print("***Account Registered Successfully***\n");
        print("Welcome " + account.getName() +
                "\nYour accont number is " + account.getAccountNumber()+"\n\n");
        goToDisplayPage();
    }

    private static void exit() {
        print("Thanks for banking with us");
        System.exit(0);
    }

    private static void print(String display) {
        System.out.print(display);
    }

    private static String input(String prompt){
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

