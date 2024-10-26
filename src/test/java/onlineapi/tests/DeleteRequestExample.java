package onlineapi.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteRequestExample 
{
	@Test
	public void testDelete()
	{
		

		baseURI="https://reqres.in";
		
		when().
		   delete("/api/users/2").
		then().
		   statusCode(204). 
		   log().all();
		 
	}

}
