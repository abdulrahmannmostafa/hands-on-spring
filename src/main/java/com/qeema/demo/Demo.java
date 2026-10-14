package com.qeema.demo;

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
			demoBeforeAdvice(accountDAO, membershipDAO);
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

}