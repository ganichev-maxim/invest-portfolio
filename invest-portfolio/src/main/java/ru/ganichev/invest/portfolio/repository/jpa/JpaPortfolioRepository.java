package ru.ganichev.invest.portfolio.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ganichev.invest.portfolio.model.Portfolio;
import ru.ganichev.invest.portfolio.repository.PortfolioRepository;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public class JpaPortfolioRepository extends AbstractDao<Portfolio> implements PortfolioRepository {

    @Override
    public List<Portfolio> getAll(long userId) {
        return em.createQuery("SELECT p FROM Portfolio p WHERE p.user.id=:userId ORDER BY p.name", Portfolio.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
