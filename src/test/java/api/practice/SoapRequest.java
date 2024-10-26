package api.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SoapRequest 
{
	@Test
	public void soapApiRequest() throws IOException 
	{
		File file = new File("./SoapRequest/Addition.xml");
		
		if(file.exists())
			System.out.println("File Exists");
		
		FileInputStream fileInput = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInput, "UTF-8");
		
		RestAssured.baseURI = "http://localhost:3000";
		
		Response response =
				given()
				.header("Content-Type","text/xml")
				.contentType(ContentType.XML)
				.accept(ContentType.XML)
				.body(requestBody)
				.when()
				.post("/calculator.asmx")
				.then()
				.statusCode(200)
				.log().all()
				.and()
				.body("//*:AddResult/text()",equalTo("12"));
		

	}
}
