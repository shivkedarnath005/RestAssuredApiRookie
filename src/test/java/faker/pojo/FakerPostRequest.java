package faker.pojo;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FakerPostRequest 
{
	Faker faker;
	Employee payload;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		payload = new Employee();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setSex(faker.options().option("Male", "Female"));
		payload.setDob(faker.date().birthday());
		payload.setAddress(faker.address().fullAddress());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setSalary(faker.number().numberBetween(10000, 100000));
		payload.setDepartment(faker.company().industry());
		
	}
	
	@Test
	public void postRequest() 
	{

		RestAssured.baseURI = "http://localhost:3000";
		
		Response response=
				 given()
				  .header("Content-Type", "application/json")
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .body(payload)
				  .log().all()
				.when()
				  .post("/employees")
				.then()
				  .statusCode(201)
				  .log().all()
				  .extract().response();
		
		System.out.println("Response Status Code :"+response.getStatusCode());
				
	}
}
