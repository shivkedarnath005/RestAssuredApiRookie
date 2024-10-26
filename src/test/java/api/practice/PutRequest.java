package api.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PutRequest 
{
	
	@Test
	public void updateUser() 
	{
		JSONObject payload = new JSONObject();
		payload.put("name", "Tanaji Sawant");
		payload.put("email", "tanajisawant@gmail.com");
		System.out.println(payload.toJSONString());
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
			given()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id","13")
				.body(payload)
				.log().all()
			.when()
				.put("/user/{id}")
			.then()
				.statusCode(200)
				.log().all()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Response Status Code : "+ response.getStatusCode());

	}
}
