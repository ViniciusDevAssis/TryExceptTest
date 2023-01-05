package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Provide account details");
		System.out.print("Nummber: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdrawal Limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter an amount to withdraw: ");
		double amount = sc.nextDouble();
		
		try{
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f%n", acc.getBalance());
		}
		catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
