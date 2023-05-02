package com.bank.application.AccountController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.application.AccountRepository.CustomerRepository;
import com.bank.application.AccountService.CustomerService;
import com.bank.application.account.entity.Customer;
import com.bank.application.exception.ResourceNotFoundException;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;
	
	@Autowired
	private CustomerRepository customerRepository;

	//create customer
	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		Customer cr = customerService.createCustomer(customer);
		System.out.println(cr.getAcctID());
		accountController.createAccount(customer.getAcctID(), 0, "Active", cr.getAcctID());
	}
	
	
	@GetMapping("/customer/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		return customerService.getCustomerInfo(acctID);
	}
	
	//get all customer
	@GetMapping("/customer")
	public List<Customer> getCustomerInfo() {
		return customerRepository.findAll();
	}
	
//	@PutMapping("/customer/{acctID}")
//	public Customer updateCustomerInfo(@PathVariable int acctID, @RequestBody Customer customerDetails) {
//		
//		return customerService.getCustomerInfo(acctID);
//		
//		
//		customer.setacctID(customerDetails.getAcctID());
//		customer.setCity(customerDetails.getCountry());
//	}

	@PutMapping("/customer/{acctID}")
	public ResponseEntity<Customer> updateCustomerInfo(@PathVariable int acctID, @RequestBody Customer customerDetails) {
		
		Customer customer = customerRepository.findById(acctID)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id :"+acctID));
		
		customer.setAcctID(customerDetails.getAcctID());
		customer.setCustName(customerDetails.getCustName());
		customer.setCity(customerDetails.getCity());
		customer.setState(customerDetails.getState());
		customer.setCountry(customerDetails.getCountry());
		customer.setPhoneNo(customerDetails.getPhoneNo());
		customer.setPassword(customerDetails.getPassword());
		
		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@DeleteMapping("/customer/{acctID}")
	public void deleteCustomer(@PathVariable int acctID) {
		customerService.deleteCustomer(acctID);
	}

}
