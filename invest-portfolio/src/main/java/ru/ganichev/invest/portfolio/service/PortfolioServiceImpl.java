package ru.ganichev.invest.portfolio.service;

import org.springframework.stereotype.Service;
import ru.ganichev.invest.portfolio.model.Portfolio;
import ru.ganichev.invest.portfolio.repository.PortfolioRepository;

import java.util.List;

@Service
public class PortfolioServiceImpl extends AbstractEntityRelatedService<Portfolio, PortfolioRepository> implements PortfolioService {

    public PortfolioServiceImpl(PortfolioRepository dao) {
        super(dao);
    }

    @Override
    public List<Portfolio> getAll(long userId) {
        return getDao().getAll(userId);
    }
}
