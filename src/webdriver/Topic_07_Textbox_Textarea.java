package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Textbox_Textarea {
	WebDriver driver;
	Random rand = new Random();
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	// Convert kiểu dữ liệu từ int sang String
	String employeeID = String.valueOf(rand.nextInt(9999));
	String passportNumber = "504107-402-96-7202";
	String comment = "My info";

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
	public void TC_01_Create_New_Employee() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sleepInSecond(3);

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();

		sleepInSecond(5);

		driver.findElement(By.xpath("//span[text()='PIM']"))
				.click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		sleepInSecond(3);

		driver.findElement(By.name("firstName")).sendKeys("Doan");
		driver.findElement(By.name("middleName")).sendKeys("Huyen");
		driver.findElement(By.name("lastName")).sendKeys("Trang");
		
		//Bôi đen dùng phím Ctrl + A
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(Keys.chord(Keys.CONTROL,"A"));
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
				.sendKeys(employeeID);
		driver.findElement(By.xpath("//input[@type = 'checkbox']/following-sibling::span")).click();
		sleepInSecond(2);

		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"))
				.sendKeys("trangdth9" + employeeID);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input"))
				.sendKeys("123456aA@");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input"))
				.sendKeys("123456aA@");

		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		sleepInSecond(8);

		// Verify dữ liệu
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Doan");
		Assert.assertEquals(driver.findElement(By.name("middleName")).getAttribute("value"), "Huyen");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "Trang");
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
						.getAttribute("value"),
				employeeID);

		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);

		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input"))
				.sendKeys(passportNumber);
		driver.findElement(By.xpath("//textarea[@placeholder ='Type Comments here']")).sendKeys(comment);
		driver.findElement(By.xpath("//button[string()=' Save ']")).click();

		sleepInSecond(5);
		driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
		sleepInSecond(5);

		// Verify dữ liệu cá nhân
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input"))
						.getAttribute("value"),
				passportNumber);
		Assert.assertEquals(
				driver.findElement(By.xpath("//textarea[@placeholder ='Type Comments here']")).getAttribute("value"),
				comment);

		// Logout
		driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		sleepInSecond(3);
	}

	@Test
	public void TC_02_Verify() {
		// Login lại vào hệ thống
		driver.findElement(By.name("username")).sendKeys("trangdth9" + employeeID);
		driver.findElement(By.name("password")).sendKeys("123456aA@");
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
		sleepInSecond(5);

		// Vào màn hình My info
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		sleepInSecond(3);

		// Verify lại các thông tin cá nhân
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Doan");
		Assert.assertEquals(driver.findElement(By.name("middleName")).getAttribute("value"), "Huyen");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "Trang");
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
						.getAttribute("value"),
				employeeID);

		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);
		driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
		sleepInSecond(5);

		// Verify dữ liệu cá nhân
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input"))
						.getAttribute("value"),
				passportNumber);
		Assert.assertEquals(
				driver.findElement(By.xpath("//textarea[@placeholder ='Type Comments here']")).getAttribute("value"),
				comment);


	}

	@Test
	public void TC_03_HTML_Dropdownlist() {
		driver.get("https://demo.nopcommerce.com/register");
		sleepInSecond(3);
		driver.findElement(By.cssSelector("a.ico-register")).click();
		sleepInSecond(5);
		
		// Nhập dữ liệu vào form
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Doan");
		driver.findElement(By.id("LastName")).sendKeys("Trang");

	}

	public void sleepInSecond(long sleepInSec) {
		try {
			Thread.sleep(sleepInSec * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}