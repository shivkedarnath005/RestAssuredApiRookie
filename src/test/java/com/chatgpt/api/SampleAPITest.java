package com.chatgpt.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleAPITest {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.get("/2");
		System.out.println("Response Body is => "+response.asString());
		System.out.println("Response Status is => "+response.getStatusCode());

	}

}
