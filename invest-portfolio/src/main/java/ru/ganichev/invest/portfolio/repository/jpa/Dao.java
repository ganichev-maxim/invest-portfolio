package ru.ganichev.invest.portfolio.repository.jpa;

import ru.ganichev.invest.portfolio.model.AbstractBaseEntity;

import java.util.Set;

public interface Dao<T extends AbstractBaseEntity> {
    void saveOrUpdate(Set<T> entities);

    T saveOrUpdate(T entity);
}
