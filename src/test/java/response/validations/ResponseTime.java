package response.validations;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseTime 
{

	public static void main(String[] args)
	{
		RestAssured.baseURI="http://localhost:3000";
		 
		  Response response=
				  given()
				    .pathParam("id","5cd6")
				    .log().all().
				  when().
				    get("/users/{id}").
				  then().
				    statusCode(200).
				    time(lessThan(2000L)).
				    log().all().
				    extract().response();
		

	}

}
