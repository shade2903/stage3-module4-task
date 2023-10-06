package com.mjs.school.controller;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;


public class AuthorRestControllerTest extends FunctionalTest {
    @Test
    public void basicPingTest() {
        given().when().get("http://localhost/8080/api/v1/author").then().statusCode(200);
    }
}
