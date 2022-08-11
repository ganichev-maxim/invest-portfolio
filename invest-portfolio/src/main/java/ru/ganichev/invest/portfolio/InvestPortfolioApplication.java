package ru.ganichev.invest.portfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ganichev.invest.portfolio.model.Portfolio;
import ru.ganichev.invest.portfolio.service.PortfolioService;

@SpringBootApplication
public class InvestPortfolioApplication {
	private final PortfolioService portfolioService;

	public InvestPortfolioApplication(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(InvestPortfolioApplication.class, args);
	}
}
