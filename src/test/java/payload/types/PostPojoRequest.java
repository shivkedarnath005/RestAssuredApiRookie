package payload.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostPojoRequest extends UserData 
{
	@Test
	public void postRequest() 
	{
		UserData payload=new UserData(8,"Vladimir Putin", "putin@gmail.com");
		
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
		
		System.out.println("Response Status Code:"+response.getStatusCode());

	}
}
