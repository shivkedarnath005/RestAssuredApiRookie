package request.setup;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import response.validations.File;

public class FileUpload 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://localhost:3000";
		 
		  Response response=
				  given()
				    .pathParam("id","5cd6")
				    .multiPart("form field", "value")
			        .multiPart("file field", new File("path to file"))
				    .log().all().
				  when().
				    get("/users/{id}").
				  then().
				    statusCode(200).
				    log().all().
				    extract().response();
		

	}

}
