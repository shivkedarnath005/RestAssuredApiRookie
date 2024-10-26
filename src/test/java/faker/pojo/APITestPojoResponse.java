package faker.pojo;

import io.restassured.RestAssured;

public class APITestPojoResponse 
{
	public static void main(String[] args) 
	{
		// Send GET request and parse response to POJO
		User user = RestAssured.get("http://localhost:3000/users/1")
				.as(User.class);

		// Now you can use the User object in your tests
		System.out.println(user);
		System.out.println("User ID: " + user.getId());
		System.out.println("User Name: " + user.getName());
		System.out.println("User Email: " + user.getEmail());
	}

}
