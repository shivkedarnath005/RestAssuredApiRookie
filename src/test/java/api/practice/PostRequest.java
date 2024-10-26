package api.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PostRequest 
{

	@Test
	public void createUser() 
	{
		JSONObject payload = new JSONObject();
		payload.put("id", "13");
		payload.put("name", "Rahul Mote");
		payload.put("email", "rahulmote@gmail.com");
		System.out.println(payload.toJSONString());
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
			given()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.log().all()
			.when()
				.post("/user")
			.then()
				.statusCode(201)
				.log().all()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println("Response Status Code : "+ response.getStatusCode());
		

	}
}
