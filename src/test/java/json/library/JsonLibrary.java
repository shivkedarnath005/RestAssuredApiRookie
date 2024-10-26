package json.library;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import api.practice.User;

public class JsonLibrary 
{

	public static void main(String[] args) 
	{
		//Json Simple Library
		JSONObject requestPayload=new JSONObject();
		requestPayload.put("subjectId", 4);
		requestPayload.put("firstName", "Hritik");
		requestPayload.put("lastName", "Roshan");
		requestPayload.put("language", "Dancer");
		System.out.println(requestPayload.toJSONString());
		
		//Jackson Library
		//Java object into json object - Serialization
		ObjectMapper mapper = new ObjectMapper(); 
		Customer customer = new Customer();
		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(customer);
		
		//Json object into java object / Deserialization
		ObjectMapper mapper = new ObjectMapper(); 
		String response = "{'name' : abc}";
		//JSON from String to Object
		User user = mapper.readValue(jsonInString, User.class);
		
		//Gson Library
		//java object ino json object
		Gson g = new Gson();
		Customer c = new Customer();//Java object 
		String data =g.toJson(c);
		
		//json object into java object
		Gson g = new Gson();
		Customer customerReference = g.fromJson(json, Customer.class);

	}

}
