package schema.validation;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonSchemaValidation 
{
  @Test
  public void getResponseSchema()
  {
	  RestAssured.baseURI="https://reqres.in/api";

	  Response response=
			  given().
			  when().
			    get("/users?page=2").
			  then().
			    assertThat().
			    body(matchesJsonSchemaInClasspath("schema.json")).
			    statusCode(200).
			    log().all().
			    extract().response();

	  //System.out.println("Response Body -"+response.getBody().asString());
	  System.out.println("Response Status Code - "+response.getStatusCode());
  }
}
