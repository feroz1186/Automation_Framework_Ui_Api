package utils;

import api.AuthService;

public class TokenManager {
	
	private static String token;
	
	public static String getToken()
	{
		if (token==null)
		{
			token=AuthService.getToken();
		}
		return token;
	}
	
	public static void refreshToken()
	{
		token=AuthService.getToken();
	}
	
	//write this in to main step definitions
	//*************************************************
//	Response response = RestAssured
//	        .given()
//	        .header("Authorization", "Bearer " + TokenManager.getToken())
//	        .get("/users");
//
//	if(response.statusCode() == 401){
//	    TokenManager.refreshToken();
//
//	    response = RestAssured
//	            .given()
//	            .header("Authorization", "Bearer " + TokenManager.getToken())
//	            .get("/users");
//	}

}
