package com.cg.ppc.dao;

import java.util.HashMap;
import java.util.Map;
import com.cg.ppc.dto.Customer;
import com.cg.ppc.exception.BankAccountException;

public class BankDAOImpl implements BankDAO{

	Map<String,Customer> custMap;

	public BankDAOImpl(){
		custMap = new HashMap<>();
		custMap.put("9523698522", new Customer("9523698522", "Karan", 22, 5000));
		custMap.put("6823920123", new Customer("6823920123", "Rahul", 23, 6000));
		custMap.put("7536202345", new Customer("7536202345", "Shikhar",22, 10000));
		custMap.put("6789658247", new Customer("6789658247", "Dinesh",24, 6000));
		custMap.put("8879630231", new Customer("8879630231", "Shashank",20, 10000));
	
	
	}

	@Override
	public void createAccount(Customer customer) {
		custMap.put(customer.getMobileNo(),customer);

	}

	@Override
	public void deposit(String mobileNo, double amount) {
		Customer customer = custMap.get(mobileNo);
		if(customer != null){
			double updateAmount = customer.getInitialBalance();
			updateAmount += amount;
			customer.setInitialBalance(updateAmount);

			custMap.put(customer.getMobileNo(), customer);
			System.out.println("Amount deposited! New balance: "+ customer.getInitialBalance());
		}
	}

	@Override
	public void withdraw(String mobileNo, double withdrawAmount) {
		Customer customer = custMap.get(mobileNo);
		if(customer != null)
		{
			double amount = customer.getInitialBalance();	



			if(amount - withdrawAmount > 100)
			{
				amount -= withdrawAmount;
				customer.setInitialBalance(amount);
				custMap.put(customer.getMobileNo(), customer);
				System.out.println("Congratulation! Withdraw Successfull ! "
						+ "New balance: "+ customer.getInitialBalance());
			}
			else
			{
				System.out.println("Cannot withdraw!insufficient bal.(Minimum balance of 100 should be maintained)");
			}
		}
		else
		{
			System.out.println("Mobile number not found");
		}

	}

	@Override
	public double checkBalance(String mobileNo) {
		Customer custCheckBalance = custMap.get(mobileNo);
		double amount = custCheckBalance.getInitialBalance();
		return amount;

	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
//		String name, newMobileNo;
//		float age;

		Customer custSender =  custMap.get(sender);
		Customer custReciever = custMap.get(reciever);

		double recieverAmount = custReciever.getInitialBalance();
		double senderAmount = custSender.getInitialBalance();
		if(senderAmount - amount > 100){
			recieverAmount += amount;//receiverAmount=receiverAmount+amount
			senderAmount -= amount;//senderAmount=senderAmount-amount
//			name = custSender.getName();
//			newMobileNo = custSender.getMobileNo();
//			age = custSender.getAge();
//
//
//			custSender.setAge(age);
//			custSender.setInitialBalance(senderAmount);
//			custSender.setMobileNo(newMobileNo);
//			custSender.setName(name);
//
//			custMap.put(newMobileNo, custSender);
//
//			name = custReciever.getName();
//			newMobileNo = custReciever.getMobileNo();
//			age = custReciever.getAge();
//
//
//			custReciever.setAge(age);
//			custReciever.setInitialBalance(recieverAmount);
//			custReciever.setMobileNo(newMobileNo);
//			custReciever.setName(name);

			custMap.put(custReciever.getMobileNo(), custReciever);	
			System.out.println("Congrats! Transfer Successful! New Balance :"+senderAmount);
		}
		else{
			System.out.println("Cannot transfer! Minimum balance of 100 should be maintained in Sender's account");
		}

	}

	@Override
	public boolean validateAccount(String mobileNo) throws BankAccountException {
		Customer customer = custMap.get(mobileNo);
		if(customer == null)
			return false;
		return true;
	}

}
