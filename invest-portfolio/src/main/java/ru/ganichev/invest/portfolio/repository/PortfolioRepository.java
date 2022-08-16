package ru.ganichev.invest.portfolio.repository;

import ru.ganichev.invest.portfolio.model.Portfolio;
import ru.ganichev.invest.portfolio.repository.jpa.Dao;

import java.util.List;

public interface PortfolioRepository extends Dao<Portfolio> {
    List<Portfolio> getAll(long userId);
}
