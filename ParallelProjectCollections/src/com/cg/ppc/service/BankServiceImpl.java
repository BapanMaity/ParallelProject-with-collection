package com.cg.ppc.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ppc.dao.BankDAO;
import com.cg.ppc.dao.BankDAOImpl;
import com.cg.ppc.dto.Customer;
import com.cg.ppc.exception.BankAccountException;


public class BankServiceImpl implements BankService{

	BankDAO dao  = new BankDAOImpl();


	@Override
	public void createAccount(Customer customer) {
		dao.createAccount(customer);		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		dao.deposit(mobileNo, amount);

	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		dao.withdraw(mobileNo, amount);

	}

	@Override
	public double checkBalance(String mobileNo) {
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		dao.fundTransfer(sender, reciever, amount);

	}

	@Override
	public boolean validateName(String name) throws BankAccountException {
		if(name == null)
			throw new BankAccountException("Name Should not be empty");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{1,10}");//min 1 max 10 in small character
		Matcher m = p.matcher(name); 
		if(!m.matches())
			System.out.println("Name invalid! Name should start with capital letter and should be of minimum 2 characters e.g Dinesh");
		return m.matches();

	}

	@Override
	public boolean validateAge(int age)  throws BankAccountException {
		try{
			if(age == 0)
				throw new BankAccountException("Age can't be empty");
			else if(age >120)
				throw new BankAccountException("Age can't be  greater than 120 ");
			else if(age < 0)
				throw new BankAccountException("Age cannot be a negative number");
			else if(age <18)
				throw new BankAccountException("Sorry! You should be 18 yrs old to register\n");
			else if(age >17)
				return true;
		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateMoileNo(String mobileNo) throws BankAccountException{
		try{
			if(mobileNo == null)
				throw new BankAccountException("Mobile can't be empty");
			Pattern p = Pattern.compile("[6789]{1}[0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.out.println("Mobile Number Invalid! Please enter valid  mobile number of 10 digits e.g 9867988985");
			return m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateAmount(double amount) throws BankAccountException {
		if(amount == 0)
			throw new BankAccountException("Amount can't be empty!!");
		String am = String.valueOf(amount);
		if(!am.matches("\\d{3,8}\\.\\d{0,2}"))
			System.out.println("Invalid Amount! Enter valid amount ");
		return (am.matches("\\d{3,9}\\.\\d{0,4}"));
	}

	@Override
	public boolean validateAccount(String mobileNo) throws BankAccountException {
		return dao.validateAccount(mobileNo);

	}

}
