package ru.ganichev.invest.portfolio.service;

import ru.ganichev.invest.portfolio.model.Portfolio;

import java.util.List;

public interface PortfolioService extends EntityRelatedService<Portfolio>{
    List<Portfolio> getAll(long userId);
}
