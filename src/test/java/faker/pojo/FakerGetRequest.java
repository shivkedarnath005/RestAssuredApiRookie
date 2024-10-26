package faker.pojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FakerGetRequest 
{
	@Test
	public void getRequest() 
	{
		
        RestAssured.baseURI = "http://localhost:3000";
		
		Response response=
				 given()
				  .log().all()
				.when()
				  .get("/employees")
				.then()
				  .statusCode(200)
				  .log().all()
				  .extract().response();
		
		System.out.println("Response Status Code : "+ response.getStatusCode());
	}

}
