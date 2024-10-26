package localhost.apitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchRequestDemo
{

	@Test 
	public void patchRequest() 
	{

		JSONObject request=new JSONObject(); 
		request.put("lastName","Glover");

		System.out.println(request.toJSONString());

		baseURI="http://localhost:3000";

		given(). 
		   body(request.toJSONString()). 
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON). 
		when(). 
		   patch("/users/cbd9"). 
		then().
		   statusCode(200). 
		   log().all();

	}
	 

}
