package raghav.playlist;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutPatchDeletExamples 
{
	
	@Test
	public void testPut()
	{
		
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
		   put("/users/2").
		then().
		   statusCode(200). 
		   log().all();
		 
	}
	
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
	
	@Test
	public void testDelete()
	{
		

		baseURI="https://reqres.in";
		
		when().
		   delete("/api/users/2").
		then().
		   statusCode(204). 
		   log().all();
		 
	}

	

}
