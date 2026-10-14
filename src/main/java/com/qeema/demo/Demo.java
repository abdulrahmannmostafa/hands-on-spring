package com.qeema.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qeema.demo.dao.AccountDAO;
import com.qeema.demo.dao.MembershipDAO;
import com.qeema.demo.entity.Account;

@SpringBootApplication
public class Demo {

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			// demoBeforeAdvice(accountDAO, membershipDAO);
			// demoAfterReturningAdvice(accountDAO);
			demoAfterThrowingAdvice(accountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		accountDAO.setName("foobar");
		accountDAO.setServiceCode(123);
		accountDAO.getName();
		accountDAO.getServiceCode();
		accountDAO.addAccount(account, true);
		String name = accountDAO.getName();
		Integer serviceCode = accountDAO.getServiceCode();
		membershipDAO.addAccount();
	}

	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("Calling findAccounts()");

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("Returned accounts: " + accounts);
	}

	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("Calling findAccounts()");

		try {
			boolean tripWire = true;
			List<Account> accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: AfterThrowingDemoApp");
			System.out.println("Exception caught: " + e);
		}
	}

}