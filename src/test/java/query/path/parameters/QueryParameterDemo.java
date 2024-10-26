package query.path.parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParameterDemo 
{
  @Test
  public void queryParameter() 
  {
	  RestAssured.baseURI="http://localhost:3000";
	  
	  Response response=
			  given().
			  queryParam("user","user").
			  log().all().
			  when().
			    get("/{user}/5").
			  then().
			    statusCode(200).
			    log().all().
			    extract().response();
	 
	  System.out.println("Response Status Code - "+response.getStatusCode());
	  
  }
}
