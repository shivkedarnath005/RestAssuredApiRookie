package response.extraction;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest 
{
	@Test
	public void getRequest() 
	{
		  RestAssured.baseURI="http://localhost:3000";
		 
		  Response response=
				  given()
				    .pathParam("id","5cd6")
				    .log().all().
				  when().
				    get("/users/{id}").
				  then().
				    statusCode(200).
				    log().all().
				    extract().response();
				    
		  JsonPath jsonPath = response.jsonPath();
		  String firstName = jsonPath.getString("firstName");
		  System.out.println("First Name : " + firstName);
		  
		  String lastName = response
	              .then()
	              .extract()
	              .path("lastName");
		  System.out.println("Last Name : " + lastName);
		  
		  int userId = response
	              .then()
	              .extract()
	              .path("id");

	      System.out.println("User ID: " + userId);


	}
}
