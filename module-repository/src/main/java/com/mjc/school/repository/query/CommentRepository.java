package com.mjc.school.repository.query;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.BaseEntity;
import com.mjc.school.repository.model.CommentModel;

import java.util.Optional;

public interface CommentRepository extends BaseRepository<CommentModel, Long> {
    public Optional<CommentModel> readByNewsId(Long newsId);
}
