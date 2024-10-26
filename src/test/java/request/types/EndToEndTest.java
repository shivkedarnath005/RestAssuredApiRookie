package request.types;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class EndToEndTest 
{
	//API CRUD Operations Methods
	//First create the user resource using post separately
	
	@Test(priority=1, description="To Read User Resource")
	public void readUser() 
	{
		RestAssured.baseURI="http://localhost:3000";

		Response response =
				given().
				pathParam("id","13ac").
				when().
				  get("/users/{id}").
				then().
				  statusCode(200).
				  log().all().
				  extract().response();
		System.out.println("Response Status Code :"+ response.getStatusCode());
	}
	
	@Test(priority=2, description="To Update User Resource")
	public void updateUser() 
	{
		JSONObject payload=new JSONObject();
		payload.put("firstName", "Chandrababu");
		payload.put("lastName", "Naidu");
		System.out.println(payload.toJSONString());

		RestAssured.baseURI="http://localhost:3000";

		Response response=
				given().
				  header("Content-Type","application/json").
				  contentType(ContentType.JSON).
				  accept(ContentType.JSON).
				  body(payload).
				  pathParam("id","13ac").
				when().
				  patch("/users/{id}").
				then().
				  statusCode(200).
				  log().all().
				  extract().response();
		System.out.println("Response Status Code : "+response.getStatusCode());

	}
	
	@Test(priority=3, description="To Delete User Resource")
	public void deleteUser() 
	{
		RestAssured.baseURI="http://localhost:3000";

		Response response=
				given().
				  pathParam("id","13ac").
				  log().all().
				when().
				  delete("/users/{id}").
				then().
				  statusCode(200).
				  log().all().
				  extract().response();
		System.out.println("Response Status Code : "+response.getStatusCode());

	}
}
