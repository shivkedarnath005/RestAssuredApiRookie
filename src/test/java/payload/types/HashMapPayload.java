package payload.types;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HashMapPayload 
{

	@Test
	public void postRequest() 
	{

		Map<String, Object> mapPayload = new HashMap<>();
		mapPayload.put("id", "10");
		mapPayload.put("name", "George Bush");
		mapPayload.put("email", "gbush@gmail.com");

		RestAssured.baseURI="http://localhost:3000";

		Response response=
				given().
				  header("Content-Type","application/json").
				  contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				  body(mapPayload).
				  log().all().
				when().
				  post("/user").
				then().
				  statusCode(201).
				  log().all().
				  extract().response();

		System.out.println("Response Status Code:"+response.getStatusCode());

	}

}
