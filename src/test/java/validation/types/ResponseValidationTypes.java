package validation.types;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import authentication.types.Path;
import authentication.types.Query;
import io.restassured.matcher.RestAssuredMatchers;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import json.library.Customer;
import json.library.User;
import response.validations.File;
import response.validations.List;

public class ResponseValidationTypes
{
	
	@Test
	public void getRequest() 
	{
		RestAssured.baseURI = "https://gorest.co.in";
		String usersEndpoint = "/public/v2/users";
		
		Map<String, Object> cookies = new HashMap<>();
	    cookies.put("session_id", "abc123");
	    cookies.put("user_id", "789xyz");
		
		Response response = RestAssured
				.given()
				.cookies(cookies)
				.header("Authorization", "Bearer Token")
				.auth()
				.basic("username", "password")
				.log().all()
				.when()
				.get(usersEndpoint);
		
		response.then().statusCode(200);
		response.then().assertThat().contentType("application/json");
		
		//Using JsonPath
		JsonPath jsonPath = response.jsonPath();
		String name = jsonPath.getString("name");
		System.out.println("Name : " + name);
		
		//Using extract().path()
		String gender = response
				.then()
				.extract()
				.path("gender");
		System.out.println("Gender : " + gender);
		
		//Extracting Values as Different Data Types and List of Data Types
		int id = response
	              .then()
	              .extract()
	              .path("id");
		System.out.println("User ID : " + id );
		
		List<Integer> ids = given()
				  .when()
				  .get("https://api.example.com/users")
				  .jsonPath().getList("id");
		
		ArrayList<String> firstName = response.path("firstName");
		System.out.println(firstName);
		
		int newId = 101;
		assertFalse(ids.contains(newId)); // Ensure newId is unique
		
		//Extracting Entire JSON as a Map
		Map<String, Object> jsonResponse = response
	              .then()
	              .extract()
	              .as(Map.class);
		System.out.println("JSON Response: " + jsonResponse);
		
		//validate the response time
		ValidatableResponse result = response.then().time(lessThan(2000L));
		System.out.println(result);
		
		long responseTimeMilliseconds = given()
                .when()
                .get("https://api.example.com/endpoint")
                .time();
                
        System.out.println("Response time: " + responseTimeMilliseconds + " milliseconds");
        
        long responseTimeInSeconds = given()
                .when()
                .get("https://api.example.com/endpoint")
                .timeIn(Duration.ofSeconds(10));
                
        System.out.println("Response time: " + responseTimeInSeconds + " seconds");
        
        
        
        long responseTime=
      		  given(). 
      		  when().
      		    get("url").
      		  then().
                  extract(). 
                  time();
        
       //validate that a list in a JSON response contains specific values
        response.then().assertThat().body(hasItems("value1","value2"));
        response.then().body("lastName",equalTo("Deokar")).
	    body("firstName",hasItems("Amol","Varsha"));
        
       //extract cookies from a response key value pair
        Map<String,String> cookiess=response.getCookies();
        
       //validate XML schema in REST Assured
        response.then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("calculator.xsd"));
        
       //validate JSON schema in REST Assured
        response.then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
        
       //handle optional fields in JSON validation
        response.then().body("$",hasKey("optional Key"));
        
      //How do you test for error responses in REST Assured - Types of Api Exceptions
        response.then().statusCode(404);
        response.then().body("error", equalTo("Not Found"));
        
      //validate deeply nested JSON structures
        response.then().body("parent.child.grandchild", equalTo("value"));
        
      //validate the response of a POST request with a payload & validate header, status code
        response.then().body("key", equalTo("value"));
        response.then().body("id", equalTo(1));
        
        //Response Header Validation
        response.then().header("Content-Type", equalTo("application/json"));
        
      //How do you handle path parameters request in REST Assured
        RestAssured.given().pathParam("id", 15).when().get("/url");
        
      //How do you handle Query parameters request in REST Assured
        RestAssured.given().queryParam("search", "T-Shirts").when().get("/url");
        
      //validate complex Nested JSON responses that contain lists and objects
        response.then().body("items.size", greaterThan(0)).
	    body("items[0].name", equalTo("item 1"));
        
      //validate multiple assertions in a single REST Assured request
        response.then().body("key1", equalTo("value1")).
        body("key2", equalTo("value2")).body("title", notNullValue());
        
      //How do you perform file upload in REST Assured
        
        given().
          multiPart(new File("path to file")).
  	  when().
  	    post("url").
  	  then().
  	    statusCode(200);
        
        //How do you perform multipart form data requests in REST Assured?
        
        given().
          multiPart("form field", "value").
          multiPart("file field", new File("path to file")).
  	  when().
  	    post("url").
  	  then().
  	    statusCode(200);
        
        //Soap API XML Body value validation with xpath
        response.then().body("//*:AddResult.text()", equalTo("12"));
        
        // Basic Authentication Old oAuth1
    	given()
    	.auth()
    	.basic("username", "password")
    	.when()
    	.get("/protected");
    	
    	// OAuth2 HTTP Bearer Token Authentication
    	given()
    	.auth()
    	.oauth2("accessToken")
    	.when()
    	.get("/protected");
    	
    	//Logging API Tests-
    	given()
        .log().all()  // Logs the request details
        .when()
        .get("/posts/1")
        .then()
        .log().all();  // Logs the response details
    	
    	//Path Parameters and Query Parameters of Request Set Up - 
    	given()
        .pathParam("id", 1)
        .queryParam("userId", 1)
        .when()
        .get("/posts/{id}")
        .then()
        .statusCode(200);
    	
    	//Jackson Library
    	
    	//Java object into json object - Serialization
    	ObjectMapper mapper = new ObjectMapper(); 
    	Customer customer = new Customer();
    	//Object to JSON in String
    	String jsonInString = mapper.writeValueAsString(customer);

    	//Json object into java object / Deserialization
    	ObjectMapper mapper = new ObjectMapper(); 
    	String response = "{'name' : abc}";
    	//JSON from String to Object
    	User user = mapper.readValue(jsonInString, User.class);

    	//Gson Library
    	//java object ino json object
    	Gson g = new Gson();
    	Customer c = new Customer();//Java object 
    	String data =g.toJson(c);

    	//json object into java object
    	Gson g = new Gson();
    	Customer customerReference = g.fromJson(json, Customer.class);
    	
    	//Deserialization -
    	User user = given()
    			.when()
    			.get("/users/1")
    			.as(User.class);
    	
    
    	/* 
    	 * Types of Request Payload
    	 * As a JSON string 
    	 * Using a HashMap 
    	 * Using a POJO (Plain Old Java Object)
    	 */
    	
    	// JSON String Payload
    	String jsonString = "{ \"name\": \"John\", \"age\": 30 }";
    	
    	// HashMap Payload
    	Map<String, Object> mapPayload = new HashMap<>();
		mapPayload.put("id", "10");
		mapPayload.put("name", "George Bush");
		mapPayload.put("email", "gbush@gmail.com");
    	
    	// POJO Class Getters and setters Payload
    	class User 
    	{
    	private String name;
    	private int age;
    	// Constructors, getters, and setters
    	}
    	User user = new User("John", 30);
    	
    	//Response Value Extraction
    	Response response = given()
    			.when()
    			.get("/users/1");

    	String dynamicValue = response.path("dynamicField");

    	// Use the dynamic value in another request
    	given()
    	.queryParam("value", dynamicValue)
    	.when()
    	.get("/otherEndpoint");
    	
    	String name = response.path("name");
    	
        
        
        

	}
}
