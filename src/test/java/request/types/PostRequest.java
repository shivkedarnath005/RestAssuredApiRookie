package request.types;

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
	public void postRequest() 
	{
		JSONObject requestPayload=new JSONObject();
		requestPayload.put("subjectId", 4);
		requestPayload.put("firstName", "Hritik");
		requestPayload.put("lastName", "Roshan");
		requestPayload.put("language", "Dancer");
		System.out.println(requestPayload.toJSONString());
		
		RestAssured.baseURI="http://localhost:3000";
		
		Response response=
				given().
				   header("Content-Type","application/json").
				   contentType(ContentType.JSON).
				   accept(ContentType.JSON).
				   body(requestPayload.toJSONString()).
				when().
				   post("/users").
				then().
				   statusCode(201).
				   log().all().
				   extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println("Status Code - "+response.getStatusCode());
		

	}
}
