package faker.pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITestPojoRequest 
{
	public static void main(String[] args) 
	{
        // Create a new User object
        User user = new User(7,"John Cena", "john.cena@gmail.com");

        // Send POST request with POJO as body
        RestAssured.
              given()
                .contentType(ContentType.JSON)
                .body(user).
              when().
                post("http://localhost:3000/users").
              then()
                .statusCode(201).
                log().all();
        
    }

}
