package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),fmt);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Enter the number of installments: ");
		int n = sc.nextInt();
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(obj,n);
		
		System.out.println("INSTALLMENTS: ");
		
		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}

	}

}
