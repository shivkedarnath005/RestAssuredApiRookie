package faker.pojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FakerDeleteRequest 
{
	@Test
	public void deleteRequest() 
	{
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
				 given()
				  .pathParam("id", 130764844)
				  .log().all()
				.when()
				  .delete("/employees/{id}")
				.then()
				  .statusCode(200)
				  .log().all()
				  .extract().response();
		
		System.out.println("Response Status Code : "+ response.getStatusCode());
	}

}
