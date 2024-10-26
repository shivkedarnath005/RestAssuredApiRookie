package com.chatgpt.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETRequestTest 
{
  @Test
  public void getRequest() 
  {
	  Response response=RestAssured.get("https://reqres.in/api/users?page=2");
	  System.out.println("GET Response Status Code is =>"+response.getStatusCode());
	  System.out.println("GET Response Body is =>"+response.getBody().asString());
	  System.out.println("GET Response Time is =>"+response.getTime());
	  System.out.println("GET Response Status Line is =>"+response.getStatusLine());
  }
}
