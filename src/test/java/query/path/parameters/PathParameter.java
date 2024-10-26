package query.path.parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParameter 
{
	@Test
	public void getRequest() 
	{
		  RestAssured.baseURI="http://localhost:3000";
		  
		  Response response=
				  given().
				  pathParam("id","5").
				  log().all().
				  when().
				    get("/user/{id}").
				  then().
				    statusCode(200).
				    log().all().
				    extract().response();
		 
		  System.out.println("Response Status Code - "+response.getStatusCode());

	}
}
