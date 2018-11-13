package com.cg.ppc.service;

import com.cg.ppc.dto.Customer;
import com.cg.ppc.exception.BankAccountException;

public interface BankService {

	public void createAccount(Customer customer);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);
	
	
	public boolean validateAccount(String mobileNo) throws BankAccountException;
	
	public boolean validateName(String name) throws BankAccountException;
	
	public boolean validateAge(int age) throws BankAccountException;
	
	public boolean validateMoileNo(String mobileNo) throws BankAccountException;
	
	public boolean validateAmount(double amount) throws BankAccountException;
			
}
