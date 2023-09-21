package com.mjc.school.service.impl;


import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.annotation.ValidateId;
import com.mjc.school.service.annotation.ValidateParam;
import com.mjc.school.service.constants.Constants;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class NewsService implements BaseService<NewsDtoRequest, NewsDtoResponse, Long> {
    private final BaseRepository<NewsModel, Long> newsRepository;
    private final BaseRepository<AuthorModel, Long> authorRepository;

    private final NewsMapper newsMapper;

    @Autowired
    public NewsService(BaseRepository<NewsModel, Long> newsRepository, BaseRepository<AuthorModel, Long> authorRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.authorRepository = authorRepository;
        this.newsMapper = newsMapper;
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsMapper.modelListToDtoList(newsRepository.readAll());
    }

    @Override
    @ValidateId
    public NewsDtoResponse readById(Long id) {
        Optional<NewsModel> newsModel = newsRepository.readById(id);
        if (newsModel.isPresent()) {
            return newsMapper.newsToDtoResponse(newsModel.get());
        }
        throw new NotFoundException(
                String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.AUTHOR, id));
    }

    @Override
    @ValidateParam
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        if (!authorRepository.existById(createRequest.getAuthorId())) {
            throw new NotFoundException(
                    String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.AUTHOR, createRequest.getAuthorId()));
        }
        NewsModel createNews = newsMapper.newsFromDtoRequest(createRequest);
        return newsMapper.newsToDtoResponse(newsRepository.create(createNews));
    }

    @Override
    @ValidateParam
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        if (!authorRepository.existById(updateRequest.getAuthorId())) {
            throw new NotFoundException(
                    String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.AUTHOR, updateRequest.getAuthorId()));
        }
        if (newsRepository.existById(updateRequest.getId())) {
            NewsModel newsModel = newsRepository.update(newsMapper.newsFromDtoRequest(updateRequest));
            return newsMapper.newsToDtoResponse(newsModel);
        }
        throw new NotFoundException(
                String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.NEWS_ID, updateRequest.getId()));
    }

    @Override
    @ValidateId
    public boolean deleteById(Long id) {
        if (newsRepository.existById(id)) {

            return newsRepository.deleteById(id);
        }
        throw new NotFoundException(
                String.format(ErrorCode.NOT_FOUND_DATA.getMessage(), Constants.NEWS_ID, id));
    }
}
