package serialization.deserialization;

import org.testng.annotations.Test;

public class SerializationDeserialization 
{
  @Test
  public void javaObjectJson() 
  {
	  
		/* Using GSON Library
		 * Java Object to JSON Object, Create an object of Gson Class //Pass the
		 * object reference of the class that we want to convert into JSON object to the
		 * toJson method.The Gson will return the JSON representation of the Java object in string format
		 */
	  Gson g = new Gson();
	  Customer c = new Customer();//Java object 
	  String data =g.toJson(c);
	  
	  //convert the API JSON Response to Java Object for validation
	  Gson g = new Gson();
	  Customer customerReference = g.fromJson(json, Customer.class);
	  
	  
	  //Using JACKSON Library
	  //Convert a Java Object to JSON object using Jackson
	  
	  ObjectMapper mapper = new ObjectMapper();
	  Customer customer = new Customer();
	  //Object to JSON in String
	  String jsonInString = mapper.writeValueAsString(customer);
	  
	  //Convert a JSON object to java object using Jackson
	  
	  ObjectMapper mapper = new ObjectMapper(); 
	  String response = "{'name' : abc}";
	  //JSON from String to Object
	  User user = mapper.readValue(jsonInString, User.class);
	  
	  
	  
	  
	  
  }
}
