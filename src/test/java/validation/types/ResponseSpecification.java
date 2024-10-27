package validation.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecification 
{
  @Test
  public void responseSpecs() 
  {
	//Reusable Response Specifications
	  ResponseSpecification responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	  
	// Build the response specification
      ResponseSpecification responseSpec = new ResponseSpecBuilder()
              .expectStatusCode(200)                                // Expected status code
              .expectContentType("application/json")                // Expected content type
              .expectResponseTime(lessThan(3000L))                  // Response time constraint
              .expectBody("size()", greaterThan(0))                 // Body should not be empty
              .build();
      
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
