package localhost.apitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetRequestDemo 
{
	

	  @Test 
	  public void getRequest() 
	  {
	  
	  
	  baseURI="http://localhost:3000";
	  
	  given(). 
	     get("/users"). 
	  then(). 
	     statusCode(200). 
	     log().all();
	  
	  }

}
