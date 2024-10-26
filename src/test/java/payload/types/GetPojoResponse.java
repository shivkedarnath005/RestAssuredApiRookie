package payload.types;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetPojoResponse 
{
	@Test
	public void getResponseTest() 
	{
		UserData user=RestAssured.get("http://localhost:3000/users/8").as(UserData.class);
		
		System.out.println(user);
		System.out.println("User Id :"+user.getId());
		System.out.println("User Name :"+user.getName());
		System.out.println("User Email :"+user.getEmail());

	}
}
