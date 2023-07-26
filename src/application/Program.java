package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter account data");
		System.out.print("number: ");
		int number = sc.nextInt();
		System.out.print("holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("new balance: %.2f%n", acc.getBalance());
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
