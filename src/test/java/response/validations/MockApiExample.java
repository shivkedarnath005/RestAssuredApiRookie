package response.validations;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class MockApiExample 
{
    public static void main(String[] args) 
    {
        // Start WireMock server on port 8080
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080));
        wireMockServer.start();

        // Define a stub for the mock API endpoint
        wireMockServer.stubFor(get(urlEqualTo("/api/test"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"message\": \"Hello, World!\" }")));

        // Your test code will go here
        
        // Stop the WireMock server
        wireMockServer.stop();
    }
}
