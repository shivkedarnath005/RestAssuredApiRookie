package response.validations;

public class ErrorResponse 
{
	given()
	.when()
	.get("/nonexistent")
	.then()
	.statusCode(404)
	.body("error", equalTo("Not Found"));

}
