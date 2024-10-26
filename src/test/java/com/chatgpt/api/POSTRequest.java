package com.chatgpt.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class POSTRequest 
{
	
	public static void main(String[] args) {
        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // JSON body to send in POST request
        String jsonBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        // Make a POST request
        Response response = given()
                                .contentType(ContentType.JSON)  // Set content type
                                .body(jsonBody)  // Attach the request body
                                .when()
                                .post("/posts")
                                .then()
                                .statusCode(201)  // Check that the status code is 201 (Created)
                                .extract()
                                .response();

        System.out.println("Response Body: " + response.getBody().asString());
    }

}
