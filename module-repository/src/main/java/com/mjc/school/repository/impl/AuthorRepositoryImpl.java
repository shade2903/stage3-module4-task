package com.mjc.school.repository.impl;

import com.mjc.school.repository.AuthorRepository;
import com.mjc.school.repository.model.AuthorModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl extends AbstractDBRepository<AuthorModel,Long> implements AuthorRepository {

    @Override
    public Optional<AuthorModel> readByNewsId(Long newsId) {
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
