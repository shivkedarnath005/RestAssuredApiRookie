package api.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchRequest 
{
	@Test
	public void partialUpdate() 
	{
		JSONObject payload = new JSONObject();
		payload.put("email", "tanajisawant123@gmail.com");
		System.out.println(payload.toJSONString());
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
			given()
				.header("ContentType","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id","13")
				.body(payload)
				.log().all()
			.when()
				.patch("/user/{id}")
			.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		System.out.println("Response Status Code : "+ response.getStatusCode());
				


	}
}
