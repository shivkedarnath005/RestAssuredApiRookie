package authentication.types;

public class Athentication 
{

	Authentication -
	given()
    .auth()
    .basic("username", "password")
    .when()
    .get("/secured-endpoint")
    .then()
    .statusCode(200);
	
	
	Logging -
	given()
    .log().all()  // Logs the request details
    .when()
    .get("/posts/1")
    .then()
    .log().all();  // Logs the response details
	
	Path Parameters and Query Parameters - 
	given()
    .pathParam("id", 1)
    .queryParam("userId", 1)
    .when()
    .get("/posts/{id}")
    .then()
    .statusCode(200);

	
	Assertions:
		given()
	    .when()
	    .get("/posts/1")
	    .then()
	    .statusCode(200)
	    .body("userId", equalTo(1))
	    .body("title", notNullValue());



	
}
