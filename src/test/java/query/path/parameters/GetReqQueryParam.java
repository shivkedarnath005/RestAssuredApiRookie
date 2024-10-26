package query.path.parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetReqQueryParam 
{
  @Test
  public void queryParamTest(String userName) 
  {
	  RestAssured.baseURI="http://localhost:3000";

	  Response response=
			  given().
			    queryParam("userName", "amol123").
			    pathParam("username", userName).
			  when().
			    get("/users/{username}").
			  then().
			    statusCode(200).
			    log().all().
			    extract().response();

	  //System.out.println("Response Body -"+response.getBody().asString());
	  System.out.println("Response Status Code - "+response.getStatusCode());
	  
  }
  
}
