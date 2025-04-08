import java.util.Scanner;

import javax.sound.midi.MidiSystem;

public class Account {
	// Class Variable
	int balance;
	int prevTransaction;
	String customerName;
	String customerID;
	
	// Class Constructor
	Account(String cname , String cid){
		customerName = cname;
		customerID = cid;
	}
	
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			prevTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			prevTransaction = -amount;
		}
	}

	void getPrevTransaction() {
		if (prevTransaction > 0) {
			System.out.println("Deposited: " + prevTransaction + "$");
		} else if (prevTransaction < 0) {
			System.out.println("Withdrown: " + Math.abs(prevTransaction) + "$");
		} else {
			System.out.println("No Transaction Occured");
		}
	}

	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + customerName + "!");
		System.out.println("Your ID is " + customerID);
		System.out.println();
		System.out.println("what Would you like to do?");
		System.out.println();
		System.out.println("A. Check Your Balance");
		System.out.println("B. Make a Desposit");
		System.out.println("C. Make a Withdraw");
		System.out.println("D. View Previous Transaction" );
		System.out.println("E. Exit");
		
		
		do {
			System.out.println();
			System.out.println("Please Enter an Option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
		switch(option) {
		case 'A':
			System.out.println("=====================");
			System.out.println("Balance = $" + balance);
			System.out.println("=====================");
			break;
		case 'B':
			System.out.println("Enter an amout to deposit: ");
			int amount = scanner.nextInt();
			deposit(amount);
			System.out.println();
			break;
		case 'C':
			System.out.println("Enter an amount to withdraw: ");
			int amount2 = scanner.nextInt();
			withdraw(amount2);
			System.out.println();
			break;
		case 'D':
			System.out.println("======================");
			getPrevTransaction();
			System.out.println("======================");
			break;
		case 'E':
			System.out.println("======================");
			break;
		default:
			System.out.println("Error!! invalid Option. Please Enter Correct one.");
			break;
		}
		}while(option != 'E') ;
		System.out.println("See You Next Time !! <3");
	}
}