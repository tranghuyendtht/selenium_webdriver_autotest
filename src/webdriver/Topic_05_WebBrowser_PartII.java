package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_WebBrowser_PartII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_Url() {

		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);

		// Page Login
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		sleepInSecond(3);

		// Compare current Link
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

		// Page register
		driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();
		sleepInSecond(3);

		// Compare current Link
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

	}

	@Test
	public void TC_02_Title() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);

		// Page Login
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		sleepInSecond(3);

		// Compare title
		Assert.assertEquals(driver.getTitle(), "Customer Login");

		// Page register
		driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();
		sleepInSecond(3);

		// Compare title
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

	}

	@Test
	public void TC_03_Navigate() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);

		// Page Login
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		sleepInSecond(3);
		// Page register
		driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();
		sleepInSecond(3);

		// Compare current Link
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

		// Back to Login Page
		driver.navigate().back();
		sleepInSecond(3);
		// Compare current Link
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

		// Forward to Register Page
		driver.navigate().forward();
		sleepInSecond(3);
		// Compare title
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

	}

	@Test
	public void TC_04_GetPageSourceCode() {

		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);
		// Page Login
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		sleepInSecond(3);

		// Verify xem trong source HTML có chứa chuỗi ký tự mong muốn hay không
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

		// Page register
		driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();
		sleepInSecond(3);

		// Verify xem trong source HTML có chứa chuỗi ký tự mong muốn hay không
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

	}

	public void sleepInSecond(long timeInSecond) {

		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}