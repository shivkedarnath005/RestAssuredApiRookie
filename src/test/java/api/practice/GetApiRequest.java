package api.practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetApiRequest 
{
	@Test
	public void getRequest() 
	{
		RestAssured.baseURI = "https://gorest.co.in";
		String usersEndpoint = "/public/v2/users";
		
		
		Response response = RestAssured
				.given()
				.log().all()
				.when()
				.get(usersEndpoint)
				.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Response Status Code : "+ response.getStatusCode());

	}
}
