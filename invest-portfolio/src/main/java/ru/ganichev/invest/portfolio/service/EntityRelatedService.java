package ru.ganichev.invest.portfolio.service;

public interface EntityRelatedService<T> {

    void saveOrUpdate(T entity);
}
