package response.validations;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetBodyContent 
{
  @Test
  public void getBodyValue() 
  {
      RestAssured.baseURI="http://localhost:3000";
	  
	  Response response=
			  given().
			  when().
			    get("/users").
			  then().
			    statusCode(200).
			    body("lastName",equalTo("Deokar")).
			    body("firstName",hasItems("Amol","Varsha")).
			    log().all().
			    extract().response();
	  
	  //System.out.println("Response Body -"+response.getBody().asString());
	  System.out.println("Response Status Code - "+response.getStatusCode());
	  
	  
	  List<Integer> ids = given()
			  .when()
			  .get("https://api.example.com/users")
			  .jsonPath().getList("id");
	  
			  int newId = 101;
			  assertFalse(ids.contains(newId)); // Ensure newId is unique
  }
}
