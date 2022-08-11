package ru.ganichev.invest.portfolio.service;

import org.springframework.stereotype.Service;
import ru.ganichev.invest.portfolio.model.Portfolio;
import ru.ganichev.invest.portfolio.repository.PortfolioRepository;

@Service
public class PortfolioServiceImpl extends AbstractEntityRelatedService<Portfolio, PortfolioRepository> implements PortfolioService {

    public PortfolioServiceImpl(PortfolioRepository dao) {
        super(dao);
    }
}
