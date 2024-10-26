package raghav.playlist;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidatior.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class JSONSchemaValidator 
{
	@Test
	public void testGet() 
	{

		baseURI="https://reqres.in/api"; 
		
		given(). 
		when().
		  get("/users?page=2"). 
		then().
		  assertThat().
		  body(matchesJsonSchemaInClasspath("schema.json")).
		  statusCode(200);
		/*
		 * body("data[4].first_name", equalTo("George")).
		 * body("data.first_name",hasItems("George","Byron"));
		 */
	}

}
