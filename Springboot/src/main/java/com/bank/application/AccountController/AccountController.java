package com.bank.application.AccountController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.application.AccountRepository.AccountsRepository;
import com.bank.application.AccountRepository.CustomerRepository;
import com.bank.application.AccountService.AccountService;
import com.bank.application.AccountService.CustomerService;
import com.bank.application.account.entity.Accounts;
import com.bank.application.account.entity.Customer;
import com.bank.application.account.entity.Logger;
import com.bank.application.response.AccountBalanceResponse;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private LoggerController loggerController;
	@Autowired
	private AccountsRepository accountRepository;
	@Autowired 
	private CustomerRepository customerRepository;

	// createAccount happens upon createCustomer
	public void createAccount( int acctID,int balance, String acctStatus, int c_id) {
		Accounts acct = new Accounts(acctID, acctStatus,c_id);
		accountService.createAccount(acct);
	}

	// checkBalance
	
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	@GetMapping("/account/{acctID}/balance")
	public AccountBalanceResponse getBalance1(@PathVariable int acctID) {
		System.out.println(acctID);
		AccountBalanceResponse accbalres = new AccountBalanceResponse();
		Accounts acc = accountRepository.getById(acctID);
		accbalres.setAcctID(acc.getAcctID());
		accbalres.setAcctStatus(acc.getAcctStatus());
		accbalres.setBalance(acc.getBalance());
		System.out.println(acc.getAcctStatus());
		System.out.println(accbalres);
		
		return accbalres;
	}
	
//	// depositAmount
//	@PutMapping("/account/{acctID}/deposit/{amount}")
//	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
//		int initBal = getBalance(acctID);
//		accountService.depositAmount(acctID, amount);
//		Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
//		loggerController.addLog(logger);
//	}
	
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		
		System.out.println("initial balance"+ initBal);
		
		accountService.depositAmount(acctID, amount);
		
		System.out.println("accid"+acctID);
		
		System.out.println("amount"+amount);
		
		Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
		loggerController.addLog(logger);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
		loggerController.addLog(logger);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		loggerController.addLog(loggerSender);
		Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		loggerController.addLog(loggerReceiver);
	}

//	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
	
		Accounts acc = accountRepository.getById(acctID);
		System.out.println("account id"+acc.getAcctID());
		System.out.println("customer id"+acc.getC_id());
		
		Customer cus = customerRepository.getById(acc.getC_id());
		System.out.println("custo id"+cus.getAcctID());
		
		
		
		accountService.deleteAccount(acctID);
		customerService.deleteCustomer(cus.getAcctID());
		System.out.println("Account ID"+acctID);
	}
//		
	
	// deleteAccount
//		@DeleteMapping("/account/{acctID}")
//		public void deleteAccount(@PathVariable int acctID) {
//			
//			accountService.deleteAccount(acctID);
//			loggerController.deleteLog(acctID);
//		}
		
//		accountService.deleteAccount(acctID);
//		loggerController.deleteLog(acctID);
	

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}

}


