package wiremock;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class ApiTest 
{

    private WireMockServer wireMockServer;

    @BeforeTest
    public void setUp() 
    {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
        wireMockServer.start();
    }

    @AfterTest
    public void tearDown() 
    {
        wireMockServer.stop();
    }

    @Test
    public void testApiCall() 
    {
        // Define a mock response
        wireMockServer.stubFor(get(urlEqualTo("/api/test"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"message\": \"success\" }")));

        // Now call your actual method to perform the HTTP request.
        // You can use HttpClient, RestTemplate, or any HTTP client library

        String response = // Your HTTP client to call /api/test

        // Perform your assertions
        assertEquals("{ \"message\": \"success\" }", response);
    }
    
    //Example: Stub a GET request
    wireMockServer.stubFor(get(urlEqualTo("/api/test"))
    	    .willReturn(aResponse()
    	        .withStatus(200)
    	        .withHeader("Content-Type", "application/json")
    	        .withBody("{ \"message\": \"success\" }")));

    //Example: Stub a POST request
    wireMockServer.stubFor(post(urlEqualTo("/api/post"))
    	    .withRequestBody(equalToJson("{ \"id\": 123 }"))
    	    .willReturn(aResponse()
    	        .withStatus(201)
    	        .withBody("{ \"status\": \"created\" }")));

    //Verifying Requests
    verify(getRequestedFor(urlEqualTo("/api/test"))
    	    .withHeader("Content-Type", equalTo("application/json")));

    //Steps for execution
    /*Example Test Execution Flow:
    	Start WireMock in the setUp() method.
    	Define API Mocks (GET, POST, PUT, etc.) inside your test.
    	Execute the HTTP request to the mock server.
    	Verify the API behavior using assertions.
    	Stop WireMock in the tearDown() method.
    */
}

