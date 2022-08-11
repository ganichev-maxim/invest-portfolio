package ru.ganichev.invest.portfolio.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ganichev.invest.portfolio.model.AbstractBaseEntity;
import ru.ganichev.invest.portfolio.repository.jpa.Dao;


public class AbstractEntityRelatedService<T extends AbstractBaseEntity, D extends Dao<T>> implements EntityRelatedService<T> {

    private D dao;

    public AbstractEntityRelatedService(D dao) {
        this.dao = dao;
    }

    public D getDao() {
        return dao;
    }

    @Transactional
    public void saveOrUpdate(T entity) {
        dao.saveOrUpdate(entity);
    }
}
