package com.chatgpt.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PUTRquest 
{
	public static void main(String[] args) {
        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // JSON body to send in PUT request
        String jsonBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        // Make a PUT request
        Response response = given()
                                .contentType(ContentType.JSON)  // Set content type
                                .body(jsonBody)  // Attach the request body
                                .when()
                                .put("/posts/1")
                                .then()
                                .statusCode(200)  // Check that the status code is 200 (OK)
                                .extract()
                                .response();

        System.out.println("Response Body: " + response.getBody().asString());
    }

}
