package ru.ganichev.invest.portfolio.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ganichev.invest.portfolio.model.Portfolio;
import ru.ganichev.invest.portfolio.repository.PortfolioRepository;


@Repository
@Transactional(readOnly = true)
public class JpaPortfolioRepository extends AbstractDao<Portfolio> implements PortfolioRepository {


}
