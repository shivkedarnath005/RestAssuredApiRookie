package faker.pojo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import com.github.javafaker.Faker;

import api.practice.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndTest extends Employee
{
	
	Faker faker;
	Employee payload;
	public Logger log;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		payload = new Employee();
		log =LogManager.getLogger(this.getClass());
		
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
	
	@Test(priority = 1)
	public void postRequest(Employee payload) 
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
		
		System.out.println("Post Response Status Code :"+response.getStatusCode());

	}
	
	@Test(priority = 2)
	public void getRequest(int id) 
	{
		
        RestAssured.baseURI = "http://localhost:3000";
		
		Response response=
				 given()
				  .pathParam("id", id)
				  .log().all()
				.when()
				  .get("/employees/{id}")
				.then()
				  .statusCode(200)
				  .log().all()
				  .extract().response();
		
		System.out.println("Get Response Status Code : "+ response.getStatusCode());
	}
	
	@Test(priority = 3)
	public void putRequest(int id, Employee payload) 
	{
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setSalary(faker.number().numberBetween(10000, 100000));
	
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
				 given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("id", id)
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
	
	@Test(priority = 4)
	public void patchRequest(int id, Employee payload) 
	{
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
				  .pathParam("id", id)
				  .body(payload)
				  .log().all()
				.when()
				  .patch("/employees/{id}")
				.then()
				  .statusCode(200)
				  .log().all()
				  .extract().response();
		
		System.out.println("Response Status Code :"+ response.getStatusCode());
		

	}
	
	@Test(priority = 5)
	public void deleteRequest(int id) 
	{
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
				 given()
				  .pathParam("id", id)
				  .log().all()
				.when()
				  .delete("/employees/{id}")
				.then()
				  .statusCode(200)
				  .log().all()
				  .extract().response();
		
		System.out.println("Response Status Code : "+ response.getStatusCode());
	}
}
