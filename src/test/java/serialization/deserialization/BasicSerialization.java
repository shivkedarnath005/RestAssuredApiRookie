package serialization.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;



public class BasicSerialization extends UserData 
{

	public static void main(String[] args) throws Exception
	{
		ObjectMapper objectMapper = new ObjectMapper();
		
		UserData user = new UserData(11, "Brian Lara", "blara@gmail.com");
		
		String jsonString = objectMapper.writeValueAsString(user);
		
		System.out.println(jsonString);

	}

}
