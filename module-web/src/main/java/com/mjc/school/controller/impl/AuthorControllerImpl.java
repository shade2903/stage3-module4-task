package com.mjc.school.controller.impl;

import com.mjc.school.controller.AuthorController;
import com.mjc.school.service.AuthorService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors",
        produces = {"application/JSON", "application/XML"})
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }


    @Override
    public AuthorDtoResponse readByIdNews(Long newsId) {
        return null;
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDtoResponse> readAll() {
        return authorService.readAll();
    }

    @Override
    @GetMapping("/{id}")
    public AuthorDtoResponse readById(@PathVariable Long id) {
        return authorService.readById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDtoResponse create(@RequestBody AuthorDtoRequest createRequest) {
        return authorService.create(createRequest);
    }

    @Override
    @PatchMapping("/{id}")
    @ResponseStatus
    public AuthorDtoResponse patch(@PathVariable Long id, @RequestBody AuthorDtoRequest updateRequest) {
        return authorService.update(updateRequest);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDtoResponse update(@PathVariable Long id, @RequestBody AuthorDtoRequest updateRequest) {
        System.out.println(updateRequest);
        return authorService.update(updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public boolean deleteById(@PathVariable  Long id) {
        return authorService.deleteById(id);
    }
}
