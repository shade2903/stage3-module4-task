package com.mjc.school.service.impl;

import com.mjc.school.repository.impl.CommentRepositoryImpl;
import com.mjc.school.repository.model.CommentModel;
import com.mjc.school.service.CommentService;
import com.mjc.school.service.annotation.ValidateId;
import com.mjc.school.service.annotation.ValidateParam;
import com.mjc.school.service.constants.Constants;
import com.mjc.school.service.dto.CommentDtoRequest;
import com.mjc.school.service.dto.CommentDtoResponse;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepositoryImpl commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepositoryImpl commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDtoResponse> readAll() {
        return commentMapper.modelListToDtoList(commentRepository.readAll());
    }

    @Override
    @ValidateId
    public CommentDtoResponse readById(Long id) {
        Optional<CommentModel> commentModel = commentRepository.readById(id);
        if(commentModel.isPresent()){
            return commentMapper.commentToDtoResponse(commentModel.get());
        }
        throw new NotFoundException(String.format(ErrorCode.NOT_FOUND_DATA.getMessage()));
    }

    @Override
    @ValidateParam
    public CommentDtoResponse create(CommentDtoRequest createRequest) {
        return commentMapper.commentToDtoResponse(
                commentRepository.create(commentMapper.commentFromDtoRequest(createRequest)));
    }

    @Override
    @ValidateParam
    public CommentDtoResponse update(CommentDtoRequest updateRequest) {
        if(commentRepository.existById(updateRequest.getId())){
            CommentModel commentModel = commentRepository.update(commentMapper.commentFromDtoRequest(updateRequest));
            return commentMapper.commentToDtoResponse(commentModel);
        }
        throw new NotFoundException(
                String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), "Comment", updateRequest.getId()));
    }

    @Override
    public boolean deleteById(Long id) {
        if(commentRepository.existById(id)){
            return commentRepository.deleteById(id);
        }
        throw new NotFoundException(
                String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), "Comment", id));
    }

    @Override
    public List<CommentDtoResponse> readByNewsId(Long newsId) {
        return commentMapper.modelListToDtoList(commentRepository.readByNewsId(newsId));
    }
}