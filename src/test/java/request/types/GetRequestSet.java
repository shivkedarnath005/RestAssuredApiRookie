package request.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetRequestSet 
{
	
  @Test
  public void getRequest() 
  {
	  RequestSpecification requestSpec = new RequestSpecBuilder()
              .setBaseUri("http://localhost:3000") 
              .addHeader("Content-Type", "application/json")       
              .addPathParam("id", "2")                          
              .build();
	  
	  ResponseSpecification responseSpec =new ResponseSpecBuilder()
			  .expectStatusCode(200).build();
	  
	  Response response=
			  given()
			  .spec(requestSpec)
			  .log().all().
			  when().
			    get("/users/{id}").
			  then().
			    spec(responseSpec).
			    log().all().
			    extract().response();
	  
	  System.out.println("Response Body -"+response.getBody().asString());
	  System.out.println("Response Status Code - "+response.getStatusCode());

  }
}
