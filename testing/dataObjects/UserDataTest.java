package dataObjects;

import org.junit.Assert;
import org.junit.Test;

public class UserDataTest {

	String password1 = new String("Password"); //Correct
	String password2 = new String("password"); //Incorrect
	
	String username1 = new String("User"); //Correct
	String username2 = new String("user"); //Incorrect
	
	UserData data = new UserData();
	
	@Test
	public void checkPasswordTest() {
		Assert.assertEquals(true,data.checkPassword(username1,password1)); //correct
		Assert.assertEquals(false,data.checkPassword(username1,password2)); //password incorrect
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void checkPasswordTest_Exceptions(){
		Assert.assertEquals(true,data.checkPassword(username2,password1));
		Assert.assertEquals(false,data.checkPassword(username2,password2)); 
	}

}
