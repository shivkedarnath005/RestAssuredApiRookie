package com.chatgpt.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class DELETERequest 
{
	public static void main(String[] args) {
        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Make a DELETE request
        Response response = given()
                                .when()
                                .delete("/posts/1")
                                .then()
                                .statusCode(200)  // Check that the status code is 200 (OK)
                                .extract()
                                .response();

        System.out.println("Response Body: " + response.getBody().asString());
    }

}
