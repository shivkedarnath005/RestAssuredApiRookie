package serialization.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicDeserialization extends UserData
{
	public static void main(String[] args) throws Exception 
	{
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonString = " { \"id\" : \"9\", \"name\" : \"Ravi Rana\", \"email\" : \"rana@gmail.com\" }";
		
		UserData user = objectMapper.readValue(jsonString, UserData.class);
		
		System.out.println("id: " + user.getId() + ", name: " + user.getName()+ 
				            ", email: " + user.getEmail());
	}

}
