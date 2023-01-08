package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_PartIII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAddress;
	String firstName;
	String middleName;
	String lastName;
	String fullName;

	
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Random rand = new Random();
		emailAddress = "automationFC" + rand.nextInt(9999) + "@gmail.com";
		
		firstName = "Doan";
		middleName = "Huyen";
		lastName = "Trang";
		fullName = firstName + " " + middleName + " "  + lastName;

	}


	
	@Test
	public void login_TC_05_createNewAccount () {
				
		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[@title = \"Create an Account\"]")).click();
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Doan");
		driver.findElement(By.cssSelector("#middlename")).sendKeys("Huyen");
		driver.findElement(By.cssSelector("#lastname")).sendKeys("Trang");
		driver.findElement(By.cssSelector("#email_address")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#password")).sendKeys("123456aA@");
		driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456aA@");
		driver.findElement(By.xpath("//button[@title = 'Register']")).click();
		
		// Verify thông báo thành công
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
		
		String contactInfomationText = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div/following-sibling::div/p")).getText();
		
		Assert.assertTrue (contactInfomationText.contains(fullName));
		Assert.assertTrue (contactInfomationText.contains(emailAddress));
		
		driver.findElement(By.xpath("//div[@class = 'page-header-container']//span[text()= 'Account']")).click();
		driver.findElement(By.xpath("//a[@title = 'Log Out']")).click();
		sleepInSecond(5);
		
		
		// Cách 1: So sánh với link url để biết đã về homepage chưa
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/");
		
		// Cách 2: Tìm element chứa ảnh trang chủ
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed());
			
		
	}
	
	@Test
	public void login_TC_06_loginValidInfo() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("#email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#pass")).sendKeys("123456aA@");
		driver.findElement(By.cssSelector("#send2")).click();
		sleepInSecond(3);
		String contactInfomationText = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue (contactInfomationText.contains(fullName));
		Assert.assertTrue (contactInfomationText.contains(emailAddress));
		
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