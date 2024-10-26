package onlineapi.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestExample
{
	@Test
	public void testPost()
	{
		Map<String, Object> map=new HashMap<String,Object>();
		
		/*
		 * map.put("name","Amol"); map.put("job","Engineer"); System.out.println(map);
		 */
		
		JSONObject request=new JSONObject();
		request.put("name","Amol");
		request.put("job","Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		   body(request.toJSONString()).
		   header("Content-Type","application/json").
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		when().
		   post("/users").
		then().
		   statusCode(201). 
		   log().all();
		 
	}

}
