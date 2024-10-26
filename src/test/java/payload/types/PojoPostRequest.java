package payload.types;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PojoPostRequest 
{
	@Test
	public void postRequest() 
	{
		User payload=new User();
		payload.setId(8);
		payload.setSubjectId(2);
		payload.setFirstName("Allu");
		payload.setLastName("Arjun");
		payload.setLanguage("Telugu Actor");
		System.out.println(payload.toString());
		
		
		System.out.println(payload);
		
		RestAssured.baseURI="http://localhost:3000";
		
		Response response=
				given().
				  header("Content-Type","application/json").
				  contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				  body(payload).
				  log().all().
				when().
				  post("/users").
				then().
				  statusCode(201).
				  log().all().
				  extract().response();
		System.out.println("Post Request Response code : "+response.getStatusCode());

	}
}
