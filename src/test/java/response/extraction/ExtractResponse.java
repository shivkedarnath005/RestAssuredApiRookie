package response.extraction;

import org.testng.annotations.Test;

public class ExtractResponse
{
  @Test
  public void f() 
  {
	  Response response = given()
			  .when()
			  .get("/users/1");
	  String name = response.path("name");
  }
}
