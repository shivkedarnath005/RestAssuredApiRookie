package localhost.apitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteRequestDemo 
{
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
