package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public abstract class AbstractDBRepository<T extends BaseEntity<K>, K> implements BaseRepository<T, K> {
    private final Class<T> entityClass;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public AbstractDBRepository() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) type.getActualTypeArguments()[0];
    }

    abstract void updatedEntityFields(T entity, T updatedEntity);

    @Override
    public List<T> readAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT e FROM" + entityClass.getName() + " e ",
                entityClass).getResultList();
    }

    @Override
    public Optional<T> readById(K id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public T create(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        T updateEntity = entityManager.getReference(entityClass, entity.getId());
        updatedEntityFields(entity, updateEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return updateEntity;
    }

    @Override
    public boolean deleteById(K id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if(readById(id).isPresent()){
            entityManager.getTransaction().begin();
            T entity = entityManager.find(entityClass, id);
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            return !existById(id);
        }
        return false;
    }

    @Override
    public boolean existById(K id) {
        return readById(id).isPresent();
    }
}
