package response.extraction;

public class DynamicDataResponse 
{
	{
		   Response response = given()
			.when()
			.get("/users/1");
		   
			String dynamicValue = response.path("dynamicField");
			
			// Use the dynamic value in another request
			given()
			.queryParam("value", dynamicValue)
			.when()
			.get("/otherEndpoint");
	}

}
