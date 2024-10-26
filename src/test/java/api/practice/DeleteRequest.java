package api.practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest 
{
	@Test
	public void deleteUser() 
	{
		RestAssured.baseURI = "http:localhost:3000";
		
		Response response = 
			given()
				.pathParam("id","12")
				.log().all()
			.when()
				.delete("/user/{id}")
			.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		System.out.println("Response Status Code : "+ response.getStatusCode());
		

	}
}
