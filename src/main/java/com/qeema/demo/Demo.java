package com.qeema.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qeema.demo.dao.AccountDAO;

@SpringBootApplication
public class Demo {

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			demoBeforeAdvice(accountDAO);

			System.out.println("Let's do it again");

			demoBeforeAdvice(accountDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO) {
		accountDAO.addAccount();
	}

}