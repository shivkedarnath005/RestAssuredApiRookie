package onlineapi.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchRequestExample 
{
	@Test
	public void testPatch()
	{
		
		JSONObject request=new JSONObject();
		request.put("name","Amol");
		request.put("job","Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		
		given().
		   body(request.toJSONString()).
		   header("Content-Type","application/json").
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		when().
		   patch("/api/users/2").
		then().
		   statusCode(200). 
		   log().all();
		 
	}

}
