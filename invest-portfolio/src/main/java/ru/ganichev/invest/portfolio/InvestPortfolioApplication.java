package ru.ganichev.invest.portfolio;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import ru.ganichev.invest.portfolio.config.AppConfig;
import ru.ganichev.invest.portfolio.config.JpaConfig;
import ru.ganichev.invest.portfolio.config.WebConfig;
import ru.ganichev.invest.portfolio.service.PortfolioService;

import static org.springframework.boot.WebApplicationType.NONE;
import static org.springframework.boot.WebApplicationType.SERVLET;

@SpringBootApplication
public class InvestPortfolioApplication {
	private final PortfolioService portfolioService;

	public InvestPortfolioApplication(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(JpaConfig.class)
				.web(NONE)
				.child(AppConfig.class)
				.web(NONE)
				.child(WebConfig.class)
				.web(SERVLET)
				.run(args);
	}
}
