package request.types;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetRequestSetting 
{
	@Test
	public void getRequest() 
	{
		// Build the request specification
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000") 
                .addHeader("Content-Type", "application/json")       
                .addParam("id", "2")                          
                .build();
        
     // Build the response specification
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)                                // Expected status code
                .expectContentType("application/json")                // Expected content type
                .expectResponseTime(lessThan(3000L))                  // Response time constraint
                .expectBody("size()", greaterThan(0))                 // Body should not be empty
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
