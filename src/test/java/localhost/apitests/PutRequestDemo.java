package localhost.apitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutRequestDemo
{
	
	@Test
	public void putRequest() 
	{

		JSONObject request=new JSONObject(); 
		request.put("firstName","Albert");
		request.put("lastName","Einstein");
		request.put("subjectId",2);

		System.out.println(request.toJSONString());

		baseURI="http://localhost:3000";

		given(). 
		    body(request.toJSONString()). 
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON). 
		when(). 
		    put("/users/cbd9").
		then().
		    statusCode(200). 
		    log().all();

	}

}
