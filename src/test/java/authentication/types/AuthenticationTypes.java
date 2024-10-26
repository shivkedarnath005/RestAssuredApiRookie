package authentication.types;

import api.practice.RequestPayloadTypes.User;

public class AuthenticationTypes 
{
	
	/*
	 * Authentication: The process of verifying the identity of a user or system
	 * (e.g., using a username and password). Authentication: Logging in with a username and password.
	 * Authorization: The process of checking
	 * the permissions or access levels of an authenticated User.
	 * Authorization: Checking if the logged-in user has permission to access a specific resource.
	 */
	
	// Basic Authentication Old oAuth1
	given()
	.auth()
	.basic("username", "password")
	.when()
	.get("/protected");
	
	// OAuth2
	given()
	.auth()
	.oauth2("accessToken")
	.when()
	.get("/protected");

}
