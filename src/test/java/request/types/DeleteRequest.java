package request.types;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest 
{
	@Test
	public void deleteRequest() 
	{
		RestAssured.baseURI="http://localhost:3000";
		
		Response response=
				given().
				when().
				  delete("/users/f9db").
				then().
				  statusCode(200).
				  log().all().
				  extract().response();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Response Status Code - "+response.getStatusCode());

	}
}
