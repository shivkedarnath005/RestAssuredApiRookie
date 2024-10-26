package request.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class GetRequest 
{
	
  @Test
  public void getRequest() 
  {
	  RestAssured.baseURI="http://localhost:3000";
	  ResponseSpecification responseSpec =new ResponseSpecBuilder().expectStatusCode(200).build();
	  
	  Response response=
			  given().
			  log().all().
			  when().
			    get("/users").
			  then().
			    spec(responseSpec).
			    log().all().
			    extract().response();
	  
	  System.out.println("Response Body -"+response.getBody().asString());
	  System.out.println("Response Status Code - "+response.getStatusCode());

  }
}
