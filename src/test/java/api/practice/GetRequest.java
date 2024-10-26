package api.practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetRequest 
{
	@Test
	public void readUser() 
	{
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
			given()
				.pathParam("id","13")
				.log().all()
			.when()
				.get("/user/{id}")
			.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Response Status Code : "+ response.getStatusCode());

	}
}
