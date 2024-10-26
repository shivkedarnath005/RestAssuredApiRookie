package response.validations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestLog 
{
  @Test
  public void getRequest() 
  {
      RestAssured.baseURI="https://reqres.in/api";
	  
	  Response response=
			  given().
			  log().all().
			  when().
			    get("/users?page=2").
			  then().
			    statusCode(200).
			    log().all().
			    extract().response();
	  
	  //System.out.println("Response Body -"+response.getBody().asString());
	  //System.out.println("Response Status Code - "+response.getStatusCode());
	  
  }
}
