package com.mjc.school.repository.impl;

import com.mjc.school.repository.AuthorRepository;
import com.mjc.school.repository.model.AuthorModel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class AuthorRepositoryImpl extends AbstractDBRepository<AuthorModel,Long> implements AuthorRepository {
    @Override
    public Optional<AuthorModel> readByNewsId(Long newsId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<AuthorModel> typedQuery =  entityManager.createQuery(
                "SELECT a FROM AuthorModel a INNER JOIN a.news n WHERE n.id=:newsId", AuthorModel.class)
                .setParameter("newsId", newsId);
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    void updatedEntityFields(AuthorModel entity, AuthorModel updatedEntity) {
       entity.setName(updatedEntity.getName());
    }
}
