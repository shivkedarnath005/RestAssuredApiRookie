package payload.types;

import java.util.HashMap;
import java.util.Map;

public class RequestPayloadTypes 
{

	/* 
	 * Types of Request Payload
	 * As a JSON string 
	 * Using a HashMap 
	 * Using a POJO (Plain Old Java Object)
	 */
	
	// JSON String
	String jsonString = "{ \"name\": \"John\", \"age\": 30 }";
	
	// HashMap
	Map<String, Object> jsonMap = new HashMap<>();
	jsonMap.put("name", "John");
	jsonMap.put("age", 30);
	
	// POJO Class Getters and setters
	class User 
	{
	private String name;
	private int age;
	// Constructors, getters, and setters
	}
	User user = new User("John", 30);

}
