package api.endpoints;

import static io.restassured.RestAssured.*;


import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	//post method 
	public static Response createUser(UserPojo Payload)
	{
		Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(Payload)
		.when()
		   .post(Routes.post_url);
		   
		   return response;
	}
	
	//get method
	public static Response readUser(String userName)
	{
		Response response = given()
		   .pathParam("username",userName)
		
		.when()
		   .get(Routes.get_url);
		  
		return response;
	}
	
	//update user
	public static Response updateUser(String userName, UserPojo Payload)
	{
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username",userName)
		   .body(Payload)
		.when()
		  .put(Routes.update_url);
		
		return response;
	}
	
	//delete User
	public static Response deleteUser(String userName)
	{
		Response response = given()
		   .pathParam("username",userName)
		
		.when()
		   .delete(Routes.delete_url);
		
		return response;
	}

}
