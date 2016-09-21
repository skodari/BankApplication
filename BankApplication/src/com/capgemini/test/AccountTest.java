package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	
	@Mock
	AccountService accountService;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		AccountService accountService = new AccountServiceImpl(accountRepository);
		
	}
	
	
	
	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountLessthan500() throws InsufficientInitialBalanceException{
		
		accountService.createAccount(101, 200);
		
		
	}
	
	
	@Test
	public void whenTheValidInfoPassedAccoountShouldCreate() throws InsufficientInitialBalanceException{
		
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accountRepository.save(account)).thenReturn(true);
		
		assertEquals(account,accountService.createAccount(101, 5000));
		
	}
	
	
	// 1. when theamount isless then 500 system should throughexception
	
	// 2./ when the valid infois paased account shouldbe created successfully
	
	
	
	

}
