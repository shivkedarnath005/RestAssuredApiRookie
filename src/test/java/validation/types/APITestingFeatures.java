package validation.types;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITestingFeatures 
{
  @Test
  public void apiTests() 
  {
	  RestAssured.baseURI="https://reqres.in/api/users?page=2";
	  
	  //validate the response content type
	  Response response=
			  given().
			  when().
			    get("url").
			  then().
			    assertThat().
			    contentType("application/json").
			    extract().response();
	  
	  //create & use a request specification
	  RequestSpecification requestSpec=new RequestSpecBuilder().
			  setBaseUri("url").
			  setheader("content-type").
			  setauth().
			  setbasic("user","psw").
			  build();
	  
			  given().
			    spec(requestSpec).
			  when().
			    get("url").
			  then().
			    statusCode(200);
			  
	 //create and use a response specification
	  ResponseSpecification responseSpec=new ResponseSpecBuilder().
			  expectStatusCode(200).
			  header("content-type").
			  body("json").
			  build();
	  
	  given().
	  when().
	    get("url").
	  then().
	    spec(responseSpec);
	  
	  //send cookies with a request
	  
	  Response response = RestAssured.given()
	            .cookie("session_id", "abc123")
	            .when()
	            .get("https://example.com/api/endpoint");
	  
	  Map<String, String> cookies = new HashMap<>();
      cookies.put("session_id", "abc123");
      cookies.put("user_id", "789xyz");

      Response response = RestAssured.given()
          .cookies(cookies)
          .when()
          .get("https://example.com/api/endpoint");
      
      //extract a value from the JSON response
      
      Response response=
			  given().
			  when().
			    get("url");
      
      //Using JsonPath
      JsonPath jsonPath = response.jsonPath();
      String title = jsonPath.getString("title");
      System.out.println("Title: " + title);
      
      //Using extract().path()
      String title = response
              .then()
              .extract()
              .path("title");

      System.out.println("Title: " + title);
      
      //Extracting Values as Different Data Types
      
      int userId = response
              .then()
              .extract()
              .path("userId");

      System.out.println("User ID: " + userId);
      
      //Extracting Entire JSON as a Map
      
      Map<String, Object> jsonResponse = response
              .then()
              .extract()
              .as(Map.class);

      System.out.println("JSON Response: " + jsonResponse);
      
      //validate the response time
      
      given().
	  when().
	    get("url").
	  then().
	    time(lessThan(2000L));
      
      //validate that a list in a JSON response contains specific values
      
      given().
	  when().
	    get("url").
	  then().
	    body("data",hasItems("value1","value2"));
      
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
      
      //extract cookies from a response key value pair
      
      Response response =given().
	  when().
	    get("url");
      
      Map<String,String> cookies=response.getCookies();
      
      //How do you measure response times in REST Assured?
      
      long responseTime=
    		  given(). 
    		  when().
    		    get("url").
    		  then().
                extract(). 
                time();
      
      //Wire mock server page no - 14 - 15
      
      //validate XML schema in REST Assured
      
      //import static io.restassured.module.jsv.XmlSchemaValidator.*;
    //import static io.restassured.module.jsv.JsonSchemaValidator.*;
      
      given().
	  when().
	    get("url").
	  then().
	    body(matchesXsdInClasspath("schema.xsd"));
      
      //handle optional fields in JSON validation
      
      given().
	  when().
	    get("url").
	  then().
	    body("$",hasKey("optional Key"));
      
      //How do you test for error responses in REST Assured
      given().
	  when().
	    get("url").
	  then().
	    statusCode(404);
      
      //validate deeply nested JSON structures
      given().
	  when().
	    get("url").
	  then().
	    body("parent.child.grandchild", equalTo("value"));
      
      //validate the response of a POST request with a payload & validate header, status code
      
      given().
      contentType("application/json").
      body("{\"key\" : \"value\"}").
	  when().
	    get("url").
	  then().
	    statusCode(201).
	    header("Content-Type", equalTo("application/json")).
	    body("key", equalTo("value"));
      
      //How do you handle path parameters request in REST Assured?
      
      given().
      pathParam("id", 1).
	  when().
	    get("/url/{id}").
	  then().
	    statusCode(200).
	    body("id", equalTo(1));
      
      //validate complex JSON responses that contain lists and objects
      
      given().
	  when().
	    get("url").
	  then().
	    statusCode(200).
	    body("items.size", greaterThan(0)).
	    body("items[0].name", equalTo("item 1"));
      
      //validate multiple assertions in a single REST Assured request
      given().
      when(). 
        get("https://api.example.com/resource"). 
      then(). 
        statusCode(200). 
        body("key1", equalTo("value1")).
        body("key2", equalTo("value2"));
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
			    
	  
  }

private ResponseAwareMatcher<Response> hasItems(String string, String string2) {
	// TODO Auto-generated method stub
	return null;
}
}
