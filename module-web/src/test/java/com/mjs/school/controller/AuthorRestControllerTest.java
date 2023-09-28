package com.mjs.school.controller;

import com.mjc.school.controller.AuthorController;
import com.mjc.school.service.AuthorService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorRestControllerTest {
    @Mock
    AuthorService authorService;

    @InjectMocks
    AuthorController authorController;
}
