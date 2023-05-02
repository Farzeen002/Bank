package com.bank.application.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.application.AccountRepository.CustomerRepository;
import com.bank.application.account.entity.Customer;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer createCustomer(Customer customer) {
		Customer cr = customerRepository.save(customer);
		return cr;
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElse(null);
	}

	public void deleteCustomer(int acctID) {
		System.out.println("inside service");
		System.out.println("service:"+acctID);
		customerRepository.deleteById(acctID);
	}

}