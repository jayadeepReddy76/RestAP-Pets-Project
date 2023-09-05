package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointsProperties {
	
	static ResourceBundle getURl()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	//post method 
	public static Response createUser(UserPojo Payload)
	{
		String post_url =getURl().getString("post_url");
		Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(Payload)
		.when()
		   .post(post_url);
		   
		   return response;
	}
	
	//get method
	public static Response readUser(String userName)
	{
		String get_url =getURl().getString("get_url");
		Response response = given()
		   .pathParam("username",userName)
		
		.when()
		   .get(get_url);
		  
		return response;
	}
	
	//update user
	public static Response updateUser(String userName, UserPojo Payload)
	{
		String update_url =getURl().getString("update_url");
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username",userName)
		   .body(Payload)
		.when()
		  .put(update_url);
		
		return response;
	}
	
	//delete User
	public static Response deleteUser(String userName)
	{
		String delete_url = getURl().getString("delete_url");
		Response response = given()
		   .pathParam("username",userName)
		.when()
		   .delete(delete_url);
		
		return response;
	}

}
