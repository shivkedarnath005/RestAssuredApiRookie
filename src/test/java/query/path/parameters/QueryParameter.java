package query.path.parameters;

import org.testng.annotations.Test;

public class QueryParameter 
{
  @Test
  public void queryParamt() 
  {
	  given()
	  .queryParam("key", "value")
	  .when()
	  .get("/endpoint").
	  then();
	  
	  
  }
}
