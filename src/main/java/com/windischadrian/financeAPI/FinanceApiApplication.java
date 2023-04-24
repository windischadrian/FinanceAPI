package com.windischadrian.financeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaRepositories
@SpringBootApplication
public class FinanceApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinanceApiApplication.class, args);

		System.setProperty("yahoofinance.baseurl.quotesquery1v7", "https://query1.finance.yahoo.com/v6/finance/quote");
	}

}
