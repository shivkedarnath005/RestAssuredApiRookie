package localhost.apitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestDemo 
{
	
	@Test 
	public void postRequest()
	{

		JSONObject request=new JSONObject(); 
		request.put("firstName","Thomas");
		request.put("lastName","Edison");
		request.put("subjectId",1);

		System.out.println(request.toJSONString());

		baseURI="http://localhost:3000";

		given(). 
		   body(request.toJSONString()). 
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON). 
		when().
		   post("/users"). 
		then(). 
		   statusCode(201).
		   log().all();

	}

}
