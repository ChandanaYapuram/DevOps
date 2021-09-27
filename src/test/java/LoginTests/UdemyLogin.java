package LoginTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class UdemyLogin {
	WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }
  @Test
  public void doLogin() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.udemy.com/");
	  driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	  driver.findElement(By.name("email")).sendKeys("admin123@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.name("submit")).click();
	  String a=driver.findElement(By.xpath("//div[contains(text(),'We found your account. It looks like a*@**')]")).getText();
	  Assert.assertEquals(a,"We found your account. It looks like a*@***m does not have an usable password. It is possible your password was reset. For more information, check with support.");
  }

}