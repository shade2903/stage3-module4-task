package com.mjc.school.repository.impl;

import com.mjc.school.repository.TagRepository;
import com.mjc.school.repository.model.TagModel;

import javax.persistence.TypedQuery;
import java.util.List;

public class TagRepositoryImpl extends AbstractDBRepository<TagModel,Long> implements TagRepository {
    @Override
    public List<TagModel> readByNewsId(Long newsId) {
        TypedQuery<TagModel> typedQuery = entityManagerFactory.createEntityManager()
                .createQuery("SELECT t FROM Tag t INNER JOIN t.news n WHERE n.id=:newsId", TagModel.class)
                .setParameter("newsId", newsId);
        return null;
    }

    @Override
    void updatedEntityFields(TagModel entity, TagModel updatedEntity) {
        entity.setName(updatedEntity.getName());
        entity.setNews(updatedEntity.getNews());

    }
}
