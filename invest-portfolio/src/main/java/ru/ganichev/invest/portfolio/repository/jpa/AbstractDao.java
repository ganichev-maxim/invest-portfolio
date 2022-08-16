package ru.ganichev.invest.portfolio.repository.jpa;

import ru.ganichev.invest.portfolio.model.AbstractBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Set;

public abstract class AbstractDao<T extends AbstractBaseEntity> implements Dao<T>{
    @PersistenceContext
    protected EntityManager em;

    private Class<T> persistentClass;

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public AbstractDao() {
        for (Type type = getClass().getGenericSuperclass(); type != null; ) {
            if (type instanceof ParameterizedType) {
                Object parameter = ((ParameterizedType) type).getActualTypeArguments()[0];

                if (parameter instanceof Class) {
                    persistentClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    if (((TypeVariable<?>) parameter).getBounds()[0] instanceof Class) {
                        persistentClass = (Class<T>) ((TypeVariable<?>) parameter).getBounds()[0];
                    } else {
                        persistentClass = (Class<T>) ((ParameterizedType) ((TypeVariable<?>) parameter).getBounds()[0]).getRawType();
                    }
                }

                break;
            } else if (type instanceof Class) {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }
    }

    @Override
    public void saveOrUpdate(Set<T> entities) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        for (T entity : entities) {
            saveOrUpdate(entity);
        }
    }

    @Override
    public T saveOrUpdate(T entity) {
        if (entity.isNew()) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }
}
