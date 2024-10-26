package response.validations;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MockApi 
{

	public static void main(String[] args) 
	{
		// Start WireMock server on port 8080
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080));
        wireMockServer.start();

        // Define a stub for the mock API endpoint
        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/test"))
            .willReturn(WireMock.aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"message\": \"Hello, World!\" }")));

        // Use REST Assured to send a GET request to the mock API
        Response response = RestAssured.given()
            .when()
            .get("http://localhost:8080/api/test");

        // Verify the response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Stop the WireMock server
        wireMockServer.stop();

	}

}
