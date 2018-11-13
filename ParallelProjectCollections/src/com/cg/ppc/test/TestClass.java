package com.cg.ppc.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.ppc.exception.BankAccountException;
import com.cg.ppc.service.BankService;
import com.cg.ppc.service.BankServiceImpl;

public class TestClass {

	@Test(expected=BankAccountException.class)
    public void Name_validator_test() throws BankAccountException{
        BankService service=new BankServiceImpl();
        service.validateName(null);
    }
    
    @Test
    public void Name_validator_test2() throws BankAccountException{
    
        String name="Bapan3265";
        BankService service=new BankServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateName_v2() throws BankAccountException{
    
        String name="Bapan";
        BankService service=new BankServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void Name_validator_test3() throws BankAccountException{
    
        String name="bapan";
        BankService service=new BankServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test
    public void MobileNo_validator() throws BankAccountException{
        BankService service=new BankServiceImpl();
        service.validateMoileNo(null);
    }
    
    @Test
    public void MobileNo_validator2() throws BankAccountException{
    
        String mobNo="ABCD91828288";
        BankService service=new BankServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void MobileNo_validator3() throws BankAccountException{
    
        String mobNo="9922974725";
        BankService service=new BankServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }
    @Test
    public void MobileNo_validator4() throws BankAccountException{
    
        String mobNo="992297";
        BankService service=new BankServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
	
}
