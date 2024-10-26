package payload.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PojoPayload extends User
{
	@Test
	public void postRequest() 
	{
		User userPayload=new User(5, 4 ,"Sharad", "Pawar", "Politics");
		
        RestAssured.baseURI="http://localhost:3000";
		
		Response response=
				given().
				  header("Content-Type","application/json").
				  contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				  body(userPayload).
				  log().all().
				when().
				  post("/users").
				then().
				  statusCode(201).
				  log().all().
				  extract().response();
		
		System.out.println("Response Status Code:"+response.getStatusCode());

	}
}
