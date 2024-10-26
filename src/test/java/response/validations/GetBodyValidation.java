package response.validations;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class GetBodyValidation 
{
	@Test
	public void getRequest() 
	{
		  RestAssured.baseURI="http://localhost:3000";
		  
		  //Reusable Response Specifications
		  ResponseSpecification responseSpec = new ResponseSpecBuilder()
					.expectStatusCode(200)
					.expectContentType(ContentType.JSON)
					.build();
		  
		  Response response=
				  given().
				  when().
				    get("/users").
				  then().
				    spec(responseSpec).
				    extract().response();
		  
		  System.out.println("Response Body -"+response.getBody().asString());
		  System.out.println("Response Status Code - "+response.getStatusCode());
		  
		  //Extract Data From Response
		  ArrayList<String> firstName = response.path("firstName");
		  System.out.println(firstName);
		  
		  //Handle Dynamic Values from API Response
		  String dynamicValue = response.path("dynamicField");
			
			// Use the dynamic value in another request
			
					given()
					.queryParam("value", dynamicValue)
					.when()
					.get("/otherEndpointURL");
		  
	}
}
