package LoginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import login.App;

public class AppTest {
  @Test(description="Check with valid credentials")
  public void validCredentials() {
	  App ap=new App();
	  boolean status=ap.userLogin("userdemo", "password");
	  Assert.assertTrue(status,"Login failed");
  }
  @Test(description="Check with invalid credentials")
  public void InvalidCredentials() {
	  App ap=new App();
	  boolean status=ap.userLogin("userdemo", "password");
	  Assert.assertTrue(status);
  }
}
