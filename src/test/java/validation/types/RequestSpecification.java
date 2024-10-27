package validation.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecification 
{
	
  @Test
  public void RequestDetails() 
  {
	// Build the request specification
      RequestSpecification requestSpec = new RequestSpecBuilder()
              .setBaseUri("http://localhost:3000") 
              .addHeader("Content-Type", "application/json")       
              .addParam("id", "2")                          
              .build();
      
   // Assign the specification to RestAssured
      RestAssured.requestSpecification = requestSpec;
      
      Response response = 
      	    given()
      		 .spec(requestSpec)
      		 .log().all()
             .when()
              .get("/usrs/{id}")
             .then()
			    .spec(responseSpec)
			    .log().all()
			    .extract().response();

    
      System.out.println(response.asString());
	  
	  
  }
}
