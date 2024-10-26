package raghav.playlist;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class TestsOnLocalAPI 
{
	
	
	  @Test 
	  public void getRequest() 
	  {
	  
	  
	  baseURI="http://localhost:3000";
	  
	  given(). 
	  get("/users")
	  . then()
	  . statusCode(200)
	  . log().all();
	  
	  }
	 
	
	
	  @Test public void postRequest() {
	  
	  JSONObject request=new JSONObject(); request.put("firstName","Thomas");
	  request.put("lastName","Edison"); request.put("subjectId",1);
	  
	  System.out.println(request.toJSONString());
	  
	  baseURI="http://localhost:3000";
	  
	  given(). body(request.toJSONString()). contentType(ContentType.JSON).
	  accept(ContentType.JSON). when(). post("/users"). then(). statusCode(201).
	  log().all();
	  
	  }
	 
	
	
	  @Test public void putRequest() {
	  
	  JSONObject request=new JSONObject(); request.put("firstName","Albert");
	  request.put("lastName","Einstein"); request.put("subjectId",2);
	  
	  System.out.println(request.toJSONString());
	  
	  baseURI="http://localhost:3000";
	  
	  given(). body(request.toJSONString()). contentType(ContentType.JSON).
	  accept(ContentType.JSON). when(). put("/users/cbd9"). then().
	  statusCode(200). log().all();
	  
	  }
	 
	
	  @Test public void patchRequest() {
	  
	  JSONObject request=new JSONObject(); request.put("lastName","Glover");
	  
	  System.out.println(request.toJSONString());
	  
	  baseURI="http://localhost:3000";
	  
	  given(). body(request.toJSONString()). contentType(ContentType.JSON).
	  accept(ContentType.JSON). when(). patch("/users/cbd9"). then().
	  statusCode(200). log().all();
	  
	  }
	 
	
	@Test
	public void testDelete()
	{
		

		baseURI="http://localhost:3000";
		
		when().
		   delete("/users/cbd9").
		then().
		   statusCode(200). 
		   log().all();
		 
	}

}
