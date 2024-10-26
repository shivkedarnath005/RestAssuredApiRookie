package payload.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PojoPutRequest 
{
	@Test
	public void putRequest() 
	{
		User payload=new User();
		payload.setSubjectId(2);
		payload.setFirstName("Dilip");
		payload.setLastName("Kumar");
		payload.setLanguage("Bollywood");
		System.out.println(payload.toString());
		
        RestAssured.baseURI="http://localhost:3000";
		
		Response response=
				given().
				  header("Content-Type","application/json").
				  contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				  body(payload).
				  pathParam("id",8).
				  log().all().
				when().
				  put("/users/{id}").
				then().
				  statusCode(200).
				  log().all().
				  extract().response();
		System.out.println("Put Request Response Code :"+response.getStatusCode());

	}
}
