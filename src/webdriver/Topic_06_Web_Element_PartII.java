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

	// @Test
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
			driver.findElement(ageRadio).click();
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

	//@Test
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

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}