package payload.types;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonStringPayload 
{
  @Test
  public void postRequest() 
  {
	 
	  String jsonString=" { \"id\" : \"9\", \"name\" : \"Ravi Rana\", \"email\" : \"rana@gmail.com\" }";
	  
	  RestAssured.baseURI="http://localhost:3000";
		
		Response response=
				given().
				  header("Content-Type","application/json").
				  contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				  body(jsonString).
				  log().all().
				when().
				  post("/user").
				then().
				  statusCode(201).
				  log().all().
				  extract().response();
		
		System.out.println("Response Status Code:"+response.getStatusCode());
	  
  }
}
