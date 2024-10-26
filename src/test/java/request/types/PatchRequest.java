package request.types;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PatchRequest 
{
  @Test
  public void patchRequest() 
  {
	  JSONObject requestPayload=new JSONObject();
	  requestPayload.put("language", "JavaScript");
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  Response response=
			  given().
			    header("Content-Type","application/json").
	            contentType(ContentType.JSON).	            
	            accept(ContentType.JSON).
	            body(requestPayload.toJSONString()).
	          when().
	            patch("/users/aa98").
	          then().
	            statusCode(200).
	            log().all().
	            extract().response();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  System.out.println("Status Code - "+response.getStatusCode());
  }  
}
