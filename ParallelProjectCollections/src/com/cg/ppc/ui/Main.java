package com.cg.ppc.ui;

import java.util.Scanner;

import com.cg.ppc.dto.Customer;
import com.cg.ppc.exception.BankAccountException;
import com.cg.ppc.service.BankService;
import com.cg.ppc.service.BankServiceImpl;

public class Main {
	public static void main(String args[]) throws BankAccountException{
		
		BankService service = new BankServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		
		String name,mobileNo;
		int age=0;
		double amount;
		int choice = 0;
		do{
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Check balance\n6.Exit");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			Customer customer;
			switch(choice){
				case 1 :					
					
							do{
							System.out.println("Enter customer name : ");
							name = sc.next();
							if(service.validateName(name))
								break;
							}
							while(true);
							
							do{
							System.out.println("Enter mobile no. : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo)) {
								
							if(service.validateAccount(mobileNo))
								System.out.println("Account already exists! Enter a new number!");
							else
								break;
							}
							}
							while(true);
							do{
							System.out.println("Enter your age : ");
							age = sc.nextInt();
							if(service.validateAge(age))
								break;
							}
							while(true);
							
							do{
							System.out.println("Enter initial amount : ");
							amount = sc.nextDouble();
							if(service.validateAmount(amount))
								break;
							}
							while(true);
							
						
						customer = new Customer();
						customer.setName(name);
						customer.setMobileNo(mobileNo);
						customer.setAge(age);;
						customer.setInitialBalance(amount);
						service.createAccount(customer);
						System.out.println(customer.toString());
						System.out.println("Customer added!");
					break;
					
				case 2 :
						do{
							do{
								System.out.println("Enter your mobile no. : ");
								mobileNo = sc.next();
								if(service.validateMoileNo(mobileNo))
									break;
								}while(true);
							
							do{
								System.out.println("Enter amount you want to deposit: ");
								amount = sc.nextDouble();
								if(service.validateAmount(amount))
									break;
								}while(true);

							if(!service.validateAccount(mobileNo))
								System.out.println("Account not found! Check mobile number");
							else
								break;
						}while(true);
						
						service.deposit(mobileNo, amount);		
					
					break;
					
				case 3 :
					do{
						do{
							System.out.println("Enter your mobile no. : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo))
								break;
							}while(true);
						
						do{
							System.out.println("Enter amount you want to withdraw: ");
							amount = sc.nextDouble();
							if(service.validateAmount(amount))
								break;
							}while(true);

						if(!service.validateAccount(mobileNo))
							System.out.println("Account not found! Check mobile number");
						else
							break;
					}while(true);
					
					customer = new Customer();
					service.withdraw(mobileNo, amount);
						
					break;
				
				case 4 :
						String mobileNoReciever;
						do{
							do{
							System.out.println("Enter your mobile number : ");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo)){
								if(service.validateAccount(mobileNo))
									break;
								else
									System.out.println("Account doesnt exists!");
							}
							}while(true);
							
							do{
							System.out.println("Enter the amount you want to transfer : ");
							amount = sc.nextDouble();
							if(service.validateAmount(amount))
								break;
							}while(true);
							
							do{
							System.out.println("Enter receivers mobile number : ");
							mobileNoReciever = sc.next();
							if(service.validateMoileNo(mobileNoReciever)){
								if(service.validateAccount(mobileNoReciever))
									break;
								else
									System.out.println("Account doesnt exists!");
							}
							}while(true);
							
							if(!mobileNo.equals(mobileNoReciever))
								break;
							else
								System.out.println("Sender and receiver mobile number cannot be same.");
							}while(true);							
						service.fundTransfer(mobileNo, mobileNoReciever, amount);
						break;
					
				case 5 :
						do{
							System.out.println("Enter the moible no to check balance");
							mobileNo = sc.next();
							if(service.validateMoileNo(mobileNo)){
								if(service.validateAccount(mobileNo))
									break;
								else
									System.out.println("Account doesnt exists!");
							}
						}while(true);
						
						System.out.println("Current Amount "+service.checkBalance(mobileNo));
						
					break;
					
				case 6 :
						System.out.println("Application terminated");
					break;
				default : System.out.println("Invalid input!");
			}
			
		}while(choice != 6);
		sc.close();
		
	}
}
