package com.chatgpt.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETRequest 
{
	public static void main(String[] args) {
        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Make a GET request
        Response response = given()
                                .when()
                                .get("/posts/1")
                                .then()
                                .statusCode(200)  // Check that the status code is 200
                                .body("userId", equalTo(1))  // Validate the userId in the response
                                .body("id", equalTo(1))  // Validate the id in the response
                                .extract()
                                .response();

        System.out.println("Response Body: " + response.getBody().asString());
    }

}
