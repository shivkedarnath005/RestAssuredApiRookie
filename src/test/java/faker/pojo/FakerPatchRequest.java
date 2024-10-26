package faker.pojo;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FakerPatchRequest 
{
	
	@Test
	public void patchRequest() 
	{
		Faker faker = new Faker();
		Employee payload = new Employee();
		
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setAddress(faker.address().fullAddress());
		payload.setSalary(faker.number().numberBetween(10000, 100000));
		payload.setDepartment(faker.company().industry());
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
				 given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("id", 130764844)
				  .body(payload)
				  .log().all()
				.when()
				  .put("/employees/{id}")
				.then()
				  .statusCode(200)
				  .log().all()
				  .extract().response();
		
		System.out.println("Response Status Code : "+ response.getStatusCode());

	}

}
