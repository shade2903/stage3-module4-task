package com.mjc.school.controller.impl;

import com.mjc.school.controller.AuthorController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.impl.AuthorServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", consumes = {"application/JSON"},
        produces = {"application/JSON", "application/XML"})
public class AuthorControllerImpl implements AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorControllerImpl(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }


    @Override
    public AuthorDtoResponse readByIdNews(Long newsId) {
        return null;
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        return null;
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        return null;
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        return null;
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
