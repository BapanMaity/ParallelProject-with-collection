package com.cg.ppc.dao;

import com.cg.ppc.dto.Customer;
import com.cg.ppc.exception.BankAccountException;

public interface BankDAO {

	public void createAccount(Customer customer);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
	
	public double checkBalance(String mobileNo);
	
	public void fundTransfer(String sender, String reciever, double amount);
	
	public boolean validateAccount(String mobileNo) throws BankAccountException;
	
}
