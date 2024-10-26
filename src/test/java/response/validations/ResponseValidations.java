package response.validations;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseValidations 
{
	//Validate Responses body fields
	given()
	.when()
	.get("/users/1")
	.then()
	.body("name", equalTo("John"))
	.body("age", equalTo(30));
	
	//Authentication Types
	
	// Basic Authentication
	given()
	.auth()
	.basic("username", "password")
	.when()
	.get("/protected");
	
	// OAuth2 Authentication
	given()
	.auth()
	.oauth2("accessToken")
	.when()
	.get("/protected");
	
	//Deserialization -
	User user = given()
			.when()
			.get("/users/1")
			.as(User.class);
	
	//Reusable Response Specifications
	ResponseSpecification responseSpec = new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.build();
	
	given()
	.when()
	.get("/users/1")
	.then()
	.spec(responseSpec);
	
	//Extract Data From Response
	Response response = given()
			.when()
			.get("/users/1");
	
	String name = response.path("name");
	
	//Handle Dynamic Values from API Response
	Response response = given()
			.when()
			.get("/users/1");
	
	String dynamicValue = response.path("dynamicField");
	
	// Use the dynamic value in another request
	
			given()
			.queryParam("value", dynamicValue)
			.when()
			.get("/otherEndpoint");
			
	
			
	
	
	

}
