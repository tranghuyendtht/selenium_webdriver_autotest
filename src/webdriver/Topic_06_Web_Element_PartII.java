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

public class Topic_06_Web_Element_PartII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	// Khai báo biến toàn cục nếu muốn tại đây, nhưng cần khai báo kiểu By
	By emailTextbox = By.id("email");
	By ageRadio = By.cssSelector("#under_18");
	By educationTextArea = By.cssSelector("#edu");
	By nameUser5 = By.xpath("//h5[text()='Name: User5']");
	By jobRole1 = By.cssSelector("#job1");
	By interestDevelopment = By.cssSelector("#development");
	By slider1 = By.cssSelector("#slider-1");
	By password = By.cssSelector("#disable_password");
	By bio = By.cssSelector("#bio");
	By jobRole3 = By.cssSelector("#job3");
	By interestDisabled = By.cssSelector("#check-disbaled");
	By slider2 = By.cssSelector("#slider-2");
	By languageJava = By.cssSelector("#java");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Truy cập vào trang https://automationfc.github.io/basic-form/index.html

		driver.get("https://automationfc.github.io/basic-form/index.html");

	}

	@Test
	public void TC_01_isDisplayed() {

		// Kiểm tra email textbox có tồn tại không
		if (driver.findElement(emailTextbox).isDisplayed()) {
			driver.findElement(emailTextbox).sendKeys("Automation Testing");
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}

		// Kiểm tra age radio có tồn tại không
		if (driver.findElement(ageRadio).isDisplayed()) {
			// driver.findElement(ageRadio).click();
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}

		// Kiểm tra eduaction textare có tồn tại không
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Automation Testing");
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}

		// Kiểm tra user5 có tồn tại không
		if (driver.findElement(nameUser5).isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}

	}

	@Test
	public void TC_02_isEnable() {

		// Kiểm tra email Textbox có enabled không
		if (driver.findElement(emailTextbox).isEnabled()) {
			System.out.println("emailTextbox is enabled");
		} else {
			System.out.println("emailTextbox is disabled");
		}

		// Kiểm tra age radio có enabled không
		if (driver.findElement(ageRadio).isEnabled()) {

			System.out.println("ageRadio is displayed");
		} else {
			System.out.println("ageRadio is not displayed");
		}

		// Kiểm tra education textare có enabled không
		if (driver.findElement(educationTextArea).isEnabled()) {

			System.out.println("educationTextArea is displayed");
		} else {
			System.out.println("educationTextArea is not displayed");
		}

		// Kiểm tra job role 1 có enabled không
		if (driver.findElement(jobRole1).isEnabled()) {

			System.out.println("jobRole1 is displayed");
		} else {
			System.out.println("jobRole1 is not displayed");
		}

		// Kiểm tra interest development checkbox có enabled không
		if (driver.findElement(interestDevelopment).isEnabled()) {

			System.out.println("interestDevelopment is displayed");
		} else {
			System.out.println("interestDevelopment is not displayed");
		}

		// Kiểm tra slider 01 có enabled không
		if (driver.findElement(slider1).isEnabled()) {

			System.out.println("slider1 is displayed");
		} else {
			System.out.println("slider1 is not displayed");
		}

		// Kiểm tra slider 01 có enabled không
		if (driver.findElement(password).isEnabled()) {

			System.out.println("password is displayed");
		} else {
			System.out.println("password is not displayed");
		}

		// Kiểm tra slider 01 có enabled không
		if (driver.findElement(bio).isEnabled()) {

			System.out.println("bio is displayed");
		} else {
			System.out.println("bio is not displayed");
		}

		// Kiểm tra slider 01 có enabled không
		if (driver.findElement(jobRole3).isEnabled()) {

			System.out.println("jobRole3 is displayed");
		} else {
			System.out.println("jobRole3 is not displayed");
		}

		// Kiểm tra slider 01 có enabled khôngz
		if (driver.findElement(interestDisabled).isEnabled()) {

			System.out.println("interestDisabled is displayed");
		} else {
			System.out.println("interestDisabled is not displayed");
		}

		// Kiểm tra slider 01 có enabled không
		if (driver.findElement(slider2).isEnabled()) {

			System.out.println("slider2 is displayed");
		} else {
			System.out.println("slider2 is not displayed");
		}

	}

	@Test
	public void TC_03_isSelected() {

		// Kiểm tra xem các rardio và Checkbox có thực sự đang không được chọn không
		Assert.assertFalse(driver.findElement(ageRadio).isSelected());
		Assert.assertFalse(driver.findElement(languageJava).isSelected());

		// Click để chọn
		driver.findElement(ageRadio).click();
		driver.findElement(languageJava).click();

		// Kiểm tra sau khi chọn
		Assert.assertTrue(driver.findElement(ageRadio).isSelected());
		Assert.assertTrue(driver.findElement(languageJava).isSelected());

		// Click để bỏ chọn
		driver.findElement(languageJava).click();

		// Kiểm tra xem đã được bỏ chọn hay chưa
		Assert.assertFalse(driver.findElement(languageJava).isSelected());
	}

	@Test
	public void TC_04_Combined() {
		driver.get("https://login.mailchimp.com/signup/");

		// Nhập dữ liệu hợp lệ vào trường email
		driver.findElement(By.cssSelector("#email")).sendKeys("trangdth.20292@gmail.com");

		By passwordAccount = By.cssSelector("#new_password");
		By buttonSignUp = By.cssSelector("");

		// Nhập pass chứa chuỗi ký tự abc in thường
		driver.findElement(passwordAccount).sendKeys("abc");
		sleepInSecond(3);

		// Verify lowercasse
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());

		// Nhập pass chứa chuỗi ký tự abc in hoa
		driver.findElement(passwordAccount).clear();
		driver.findElement(passwordAccount).sendKeys("ABC");

		sleepInSecond(3);
		// Verify Upper Case
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());

		// Nhập pass chứa chuỗi số
		driver.findElement(passwordAccount).clear();
		driver.findElement(passwordAccount).sendKeys("123");

		sleepInSecond(3);
		// Verify Upper Case
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());

		// Nhập pass chứa chuỗi ký tự đặc biệt
		driver.findElement(passwordAccount).clear();
		driver.findElement(passwordAccount).sendKeys("@#$");

		sleepInSecond(3);
		// Verify Upper Case
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());

		// Nhập pass nhiều hơn 8 ký tự
		driver.findElement(passwordAccount).clear();
		driver.findElement(passwordAccount).sendKeys("123456789");

		sleepInSecond(3);
		// Verify Upper Case
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char completed']")).isDisplayed());

		// Nhập pass hợp lệ tất cả các điều kiện
		driver.findElement(passwordAccount).clear();
		driver.findElement(passwordAccount).sendKeys("123456aA@");

		sleepInSecond(3);
		// Verify Upper Case
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = '8-char completed']")).isDisplayed());

	}

	@Test
	public void loginEmptyData() {
		// Login vào trang http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);

		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		driver.findElement(By.cssSelector("#send2")).click();
		sleepInSecond(3);

		// Verify thông báo lỗi
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-email")).getText(),
				"This is a required field.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-pass")).getText(),
				"This is a required field.");

	}
	
	@Test
	public void loginInvalidEmail() {
		// Login vào trang http://live.techpanda.org/
				driver.get("http://live.techpanda.org/");
				sleepInSecond(3);

				driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
				sleepInSecond(3);
				
				
				// Nhập sai thông tin email
				driver.findElement(By.cssSelector("#email")).sendKeys("1234@123123");
				driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
				driver.findElement(By.cssSelector("#send2")).click();
				sleepInSecond(3);

				// Verify thông báo lỗi
				Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-email-email")).getText(),
						"Please enter a valid email address. For example johndoe@domain.com.");
				
	}
	
	@Test
	public void loginInvalidPassword() {
		// Login vào trang http://live.techpanda.org/
				driver.get("http://live.techpanda.org/");
				sleepInSecond(3);

				driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
				sleepInSecond(3);
				
				
				// Nhập sai thông tin email
				driver.findElement(By.cssSelector("#email")).sendKeys("automation@gmail.com");
				driver.findElement(By.cssSelector("#pass")).sendKeys("126");
				driver.findElement(By.cssSelector("#send2")).click();
				sleepInSecond(3);

				// Verify thông báo lỗi
				Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-password-pass")).getText(),
						"Please enter 6 or more characters without leading or trailing spaces.");
				
	}
	
	@Test
	public void loginInvalidEmailOrPassword() {
		// Login vào trang http://live.techpanda.org/
				driver.get("http://live.techpanda.org/");
				sleepInSecond(3);

				driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
				sleepInSecond(3);
				
				
				// Nhập sai thông tin email
				driver.findElement(By.cssSelector("#email")).sendKeys("automation@gmail.com");
				driver.findElement(By.cssSelector("#pass")).sendKeys("126123456");
				driver.findElement(By.cssSelector("#send2")).click();
				
				sleepInSecond(3);

				// Verify thông báo lỗi
				Assert.assertEquals(driver.findElement(By.xpath("//li[@class = 'error-msg']//span")).getText(),
						"Invalid login or password.");
				
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