package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPointsProperties;
import api.payload.UserPojo;
import io.restassured.response.Response;

public class UserTestProp {

	 Faker faker;
	 UserPojo userPayload;
	 
	 public Logger logger;
	 
	 @BeforeClass
	 public void setupData()
	 {
		 faker = new Faker();
		 userPayload = new UserPojo();
		 
		 userPayload.setId(faker.idNumber().hashCode());
		 userPayload.setusername(faker.name().username());
		 userPayload.setfirstName(faker.name().firstName());
		 userPayload.setlastName(faker.name().lastName());
		 userPayload.setEmail(faker.internet().safeEmailAddress());
		 userPayload.setPhone(faker.phoneNumber().phoneNumber());
		 userPayload.setPassword(faker.internet().password(5, 10));
		 
		 //logs
		 logger = LogManager.getLogger(this.getClass());
		 
	 }
	 
	 @Test(priority=1)
	 public void testPostUser()
	 {
		logger.info("*********  Creating User ***********" );
		
		Response response = UserEndPointsProperties.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************ User is Created ************");
	 }
	 
	 @Test(priority=2)
	 public void testGetUserByName()
	 {
		logger.info("********* Reading User Info ***********");
		Response response = UserEndPointsProperties.readUser(this.userPayload.getusername());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("*********User Info is displayed ***********");
	 }
	 
	 @Test(priority=3)
	 public void testUpdateUserName()
	 {
		 logger.info("********* Updateing User ***********");
		 userPayload.setfirstName(faker.name().firstName());
		 userPayload.setlastName(faker.name().lastName());
		 userPayload.setEmail(faker.internet().emailAddress());
		 
		 Response response = UserEndPointsProperties.updateUser(this.userPayload.getusername(),userPayload);
		 response.then().log().body();
		 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 //check data after response
		 Response Updateuserdata = UserEndPointsProperties.readUser(this.userPayload.getusername());
		 Updateuserdata.then().log().all();
		 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 logger.info("********* User Updated ***********");
	 }
	 
	 @Test(priority=4)
	 public void testDeleteUserByName()
	 {
		 logger.info("********* Deleting User ***********");
		 Response response = UserEndPointsProperties.deleteUser(this.userPayload.getusername());
		 Assert.assertEquals(response.getStatusCode(), 200);
		 logger.info("*********User Deleted ***********");
	 }
}
