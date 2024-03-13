package checkout;

import ticTacToe.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CheckOutApp {

		private static final LocalDateTime myDateObj = LocalDateTime.now() ;
		private static final DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
		private static final String formattedDate = myDateObj.format(myFormatObj) ;

		private static final Scanner input = new Scanner(System.in) ;

		private static String customerName ;
		private static String cashierName ;
		private static final ArrayList<String> itemsBought = new ArrayList<>() ;
		private static final ArrayList<Integer> piecesBought = new ArrayList<>() ;
		private static final ArrayList<Double> pricePerUnit = new ArrayList<>() ;
		private static double discount ;
		private static final ArrayList<Double> totalPerUnit = new ArrayList<>() ;
		private static int counter = 0;

        public void setDiscount(double discount){
            if (discount < 0.0) throw new InvalidInputException("Number can't be lesser than 0.0");
            CheckOutApp.discount = discount;
        }

	public void mainApp() {

		System.out.println("What is the customer's Name?") ;
		customerName = input.nextLine();

		while (counter != -1) {
			System.out.println("What did the user buy?");
			String itemBought =input.next() ;
			itemsBought.add(itemBought);

			System.out.println("How many pieces?");
			int pieceBought = input.nextInt() ;
			piecesBought.add(pieceBought);

			System.out.println("How much per unit? ") ;
			double price = input.nextDouble() ;
			pricePerUnit.add(price);

			double itemTotalPrice = pieceBought * price ;
			totalPerUnit.add(itemTotalPrice) ;

			System.out.println("Add more items?") ;
			String addMore = input.next() ;

			if (addMore.equalsIgnoreCase( "yes")) {
				counter ++ ;
			} else {
					counter = -1;
					System.out.println("\n\nWhat is your name?") ;
					cashierName = input.next() ;

					System.out.println("How much discount will he get?") ;
					double discountPrice = input.nextDouble() ;

                    try {
                        this.setDiscount(discountPrice);
                    } catch (InvalidInputException e){
                        System.out.println(e.getMessage());
                    }

					System.out.println() ;
					System.out.println() ;
			}
		}
		invoice() ;
	}

	public static void invoice () {
		System.out.println("SEMICOLON STORES \nMAIN BRANCH \nLOCATION: 312, HERBERT MACAULEY WAY, SABO YABA, LAGOS. \nTEL: 03293828343") ;
		System.out.println("Date: " + formattedDate) ;
		System.out.printf("Cashier: %s \nCustomer Name: %s \n", cashierName, customerName) ;
		System.out.println("========================================================") ;
		System.out.printf("%20s%10s%10s%15s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)") ;
		System.out.println("--------------------------------------------------------") ;

		for (int item = 0; item <= itemsBought.size(); item++) {
			System.out.printf("%20s%10d%10.2f%15.2f%n", itemsBought.get(item), piecesBought.get(item), pricePerUnit.get(item), totalPerUnit.get(item)) ;
		}

		System.out.println("\n--------------------------------------------------------") ;

		double subTotal = 0 ;
		for (int price = 0; price <= totalPerUnit.size() - 1; price ++) {
			subTotal += totalPerUnit.get(price);
		}

		double discountPrice = (subTotal * discount) / 100 ;
		double vAT =  subTotal * 0.075 ;
		double total = (subTotal - discountPrice) + vAT ;

		System.out.printf("%45s%10.2f%n%45s%10.2f%n%45s%10.2f%n", "Sub Total: ", subTotal, "Discount:", discountPrice, "VAT @ 7.50%:",vAT) ;
		System.out.println("========================================================") ;
		System.out.printf("%45s%10.2f%n", "Bill Total:", total) ;
		System.out.println("========================================================") ;
		System.out.printf("THIS IS NOT A RECEIPT, KINDLY PAY %.2f%n", total) ;
		System.out.println("========================================================\n\n") ;

		System.out.println("How much did the customer give to you?");
		double amountPaid = input.nextInt() ;

		while (amountPaid < total) {
			System.out.println("Your payment is not up to what you purchased") ;
			System.out.println("Enter a new amount: ");
			amountPaid = input.nextInt() ;
		}
		double balance = amountPaid - total ;

		System.out.println("\n\n");

		System.out.println("SEMICOLON STORES \nMAIN BRANCH \nLOCATION: 312, HERBERT MACAULEY WAY, SABO YABA, LAGOS. \nTEL: 03293828343") ;
		System.out.println("Date: " + formattedDate) ;
		System.out.printf("Cashier: %s \nCustomer Name: %s \n", cashierName, customerName) ;
		System.out.println("========================================================") ;
		System.out.printf("%20s%10s%10s%15s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)") ;
		System.out.println("--------------------------------------------------------") ;

		for (int item = 0; item <= itemsBought.size(); item++) {
			System.out.printf("%20s%10d%10.2f%15.2f%n", itemsBought.get(item), piecesBought.get(item), pricePerUnit.get(item), totalPerUnit.get(item)) ;
		}

		System.out.println("\n--------------------------------------------------------") ;

		System.out.printf("%45s%10.2f%n%45s%10.2f%n%45s%10.2f%n", "Sub Total: ", subTotal, "Discount:", discountPrice, "VAT @ 7.50%:",vAT) ;
		System.out.println("========================================================") ;
		System.out.printf("%45s%10.2f%n%45s%10.2f%69s%10.2f%n", "Bill Total:", total, "Amount Paid:", amountPaid, "Balance:", balance) ;
		System.out.println("========================================================") ;
		System.out.print("                THANK YOU FOR YOUR PATRONAGE") ;
		System.out.print("\n========================================================") ;
	}

	public static void main (String[] args) {
            CheckOutApp checkOutApp = new CheckOutApp();
            checkOutApp.mainApp();
	}

}
