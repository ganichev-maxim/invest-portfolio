package ru.ganichev.invest.portfolio.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages={"ru.ganichev.invest.portfolio.service"})
@EnableAutoConfiguration
@Configuration
public class AppConfig {
}
