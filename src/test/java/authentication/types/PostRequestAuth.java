package authentication.types;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PostRequestAuth 
{
  @Test
  public void postReqAuthentication() 
  {
	    JSONObject requestPayload=new JSONObject();
		requestPayload.put("name", "Amol Deokar");
		requestPayload.put("gender", "male");
		requestPayload.put("email", "amol@gmail.com");
		requestPayload.put("status", "active");
		System.out.println(requestPayload.toJSONString());
		
		RestAssured.baseURI="https://gorest.co.in";
		
		Response response=
				given().
				   header("Content-Type","application/json").
				   header("Authorization","Bearer ACCESS-TOKEN").
				   auth().
				   oauth2("349e46ccd9cd560c37bd45f101e06a8bfc81ba1197f008d08da86cb741884880").
				   contentType(ContentType.JSON).
				   accept(ContentType.JSON).
				   body(requestPayload.toJSONString()).
				when().
				   post("/public/v2/users").
				then().
				   statusCode(201).
				   log().all().
				   extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println("Status Code - "+response.getStatusCode());
	  
  }
  
}
