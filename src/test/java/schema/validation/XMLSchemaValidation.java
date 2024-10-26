package schema.validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation 
{
	@Test
	public void schemaValidation() throws IOException 
	{
        File file=new File("./SoapRequest/Addition.xml");
		
		if(file.exists())
			System.out.println("File Exists");
		
		FileInputStream fileinputstream=new FileInputStream(file);
		String requestBody=IOUtils.toString(fileinputstream, "UTF-8");
		
		baseURI="http://www.dneonline.com";
		
		given().
		   contentType("text/xml").
		   accept(ContentType.XML).
		   body(requestBody).
		when().
		   post("/calculator.asmx"). 
		then(). 
		   statusCode(200). 
		   log().all(). 
	    and(). 
	       body("//*:AddResult.text()", equalTo("12")). 
	    and(). 
	       assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("calculator.xsd"));


	}
}
