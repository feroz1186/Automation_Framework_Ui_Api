package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthService {
	
public static String getToken()
{
	Response response=RestAssured.given()
	.baseUri(getToken())
	.contentType(ContentType.JSON)
	.body("")
	.post("specify correct url");
	
	return response.jsonPath().getString("tokenId");
}
	
}
